package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.dto.RestauranteNewDTO;
import com.gestaofilas.entity.enums.Perfil;

// TODO: Auto-generated Javadoc
/**
 * Classe Restaurante.
 */
@Entity
public class Restaurante extends Usuario implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The razao social. */
	private String razaoSocial;
	
	/** The nome. */
	private String nome;
	
	/** The cnpj. */
	private String cnpj;
	
	/** The categorias. */
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Restaurante_Categoria",
		joinColumns = @JoinColumn(name = "idRestaurante"),
		inverseJoinColumns = @JoinColumn(name = "idCategoria"))
	private List<Categoria> categorias = new ArrayList<>();
	
	/** The endereco restaurante. */
	@OneToOne
	@JoinColumn(name="idEndereco")
	private EnderecoRestaurante enderecoRestaurante;
	
	/** The telefones restaurante. */
	@OneToMany(mappedBy="restaurante", cascade=CascadeType.ALL)
	private List<TelefoneRestaurante> telefonesRestaurante= new ArrayList<>();
	
	/** The reservas. */
	@JsonIgnore
	@OneToMany(mappedBy="restaurante")
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	/**
	 * Instancia um novo restaurante.
	 */
	public Restaurante() {
		addPerfil(Perfil.RESTAURANTE);
	}

	/**
	 * Instancia um novo restaurante.
	 *
	 * @param id the id
	 * @param razaoSocial the razao social
	 * @param nomeFantasia the nome fantasia
	 * @param cnpj the cnpj
	 * @param email the email
	 * @param senha the senha
	 */
	public Restaurante(Integer id, String razaoSocial, String nomeFantasia, String cnpj, String email, String senha) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nome = nomeFantasia;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.RESTAURANTE);
	}
	
	/**
	 * Instancia um novo restaurante.
	 *
	 * @param obj the obj
	 */
	public Restaurante(RestauranteNewDTO obj) {
		this.razaoSocial = obj.getRazaoSocial();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	/**
	 * Pega o id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Define o id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Pega a razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Define a razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Pega o nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome.
	 *
	 * @param nomeFantasia the new nome
	 */
	public void setNome(String nomeFantasia) {
		this.nome = nomeFantasia;
	}

	/**
	 * Pega o CNPJ.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Define o CNPJ.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Pega o email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define o email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Pega a senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define a senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Pega as categorias.
	 *
	 * @return the categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Define as categorias.
	 *
	 * @param categorias the new categorias
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * Pega o endereco.
	 *
	 * @return the endereco
	 */
	public EnderecoRestaurante getEndereco() {
		return enderecoRestaurante;
	}

	/**
	 * Define o endereco.
	 *
	 * @param enderecoRestaurante the new endereco
	 */
	public void setEndereco(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

	/**
	 * Pega os telefones do restaurante.
	 *
	 * @return the telefones restaurante
	 */
	public List<TelefoneRestaurante> getTelefonesRestaurante() {
		return telefonesRestaurante;
	}

	/**
	 * Define os telefones do restaurante.
	 *
	 * @param telefonesRestaurante the new telefones restaurante
	 */
	public void setTelefonesRestaurante(List<TelefoneRestaurante> telefonesRestaurante) {
		this.telefonesRestaurante = telefonesRestaurante;
	}
	
	/**
	 * Pega as reservas.
	 *
	 * @return the reservas
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * Define as reservas.
	 *
	 * @param reservas the new reservas
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Igualdade.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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
