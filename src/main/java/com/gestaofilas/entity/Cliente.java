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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.dto.ClienteNewDTO;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	
	@JsonIgnore
	private String senha;
	
	private String cpf;
	
	@OneToOne
	@JoinColumn(name="idEndereco")
	private EnderecoCliente endereco;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<TelefoneCliente> telefones = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Cliente() {
	}

	public Cliente(Integer id, String nomeCliente, String email, String cpf, String senha) {
		this.id = id;
		this.nome = nomeCliente;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public Cliente(ClienteNewDTO obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoCliente getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneCliente> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneCliente> telefones) {
		this.telefones = telefones;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
