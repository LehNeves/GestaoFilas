package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.dto.RestauranteNewDTO;

@Entity
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String razaoSocial;
	private String nome;
	private String cnpj;
	private String email;
	
	@JsonIgnore
	private String senha;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Restaurante_Categoria",
		joinColumns = @JoinColumn(name = "idRestaurante"),
		inverseJoinColumns = @JoinColumn(name = "idCategoria"))
	private List<Categoria> categorias = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="idEndereco")
	private EnderecoRestaurante enderecoRestaurante;
	
	@OneToMany(mappedBy="restaurante", cascade=CascadeType.ALL)
	private List<TelefoneRestaurante> telefonesRestaurante= new ArrayList<>();
	
	@OneToMany(mappedBy="restaurante")
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	public Restaurante() {
	}

	public Restaurante(Integer id, String razaoSocial, String nomeFantasia, String cnpj, String email, String senha) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nome = nomeFantasia;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
	}
	
	public Restaurante(RestauranteNewDTO obj) {
		this.razaoSocial = obj.getRazaoSocial();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nome;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nome = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public EnderecoRestaurante getEndereco() {
		return enderecoRestaurante;
	}

	public void setEndereco(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

	public List<TelefoneRestaurante> getTelefonesRestaurante() {
		return telefonesRestaurante;
	}

	public void setTelefonesRestaurante(List<TelefoneRestaurante> telefonesRestaurante) {
		this.telefonesRestaurante = telefonesRestaurante;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
