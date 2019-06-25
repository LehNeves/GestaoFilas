package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.dto.ClienteNewDTO;
import com.gestaofilas.entity.enums.Perfil;

// TODO: Auto-generated Javadoc
/**
 * Classe Cliente.
 */
@Entity
public class Cliente extends Usuario implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nome. */
	private String nome;
	
	/** The cpf. */
	private String cpf;
	
	/** The endereco. */
	@OneToOne
	@JoinColumn(name="idEndereco")
	private EnderecoCliente endereco;
	
	/** The telefone. */
	@OneToOne(mappedBy="cliente", cascade=CascadeType.ALL)
	private TelefoneCliente telefone;
	
	/** The reservas. */
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas = new ArrayList<>();
	
	/**
	 * Instancia um novo cliente.
	 */
	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	/**
	 * Instancia um novo cliente.
	 *
	 * @param id the id
	 * @param nomeCliente the nome cliente
	 * @param email the email
	 * @param cpf the cpf
	 * @param senha the senha
	 */
	public Cliente(Integer id, String nomeCliente, String email, String cpf, String senha) {
		this.id = id;
		this.nome = nomeCliente;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}
	
	/**
	 * Instancia um novo cliente.
	 *
	 * @param obj the obj
	 */
	public Cliente(ClienteNewDTO obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
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
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * Pega o cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Define o cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Pega o endereco.
	 *
	 * @return the endereco
	 */
	public EnderecoCliente getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

	/**
	 * Pega o telefone.
	 *
	 * @return the telefone
	 */
	public TelefoneCliente getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone.
	 *
	 * @param telefones the new telefone
	 */
	public void setTelefone(TelefoneCliente telefones) {
		this.telefone = telefones;
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
}
