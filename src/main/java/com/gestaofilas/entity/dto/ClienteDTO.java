package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Cliente;

// TODO: Auto-generated Javadoc
/**
 * Classe ClienteDTO.
 */
public class ClienteDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/** The email. */
	private String email;
	
	/**
	 * Instancia um novo cliente DTO.
	 */
	public ClienteDTO() {
	}
	
	/**
	 * Instancia um novo cliente DTO.
	 *
	 * @param obj the obj
	 */
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
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
	 * Pega o nome do cliente.
	 *
	 * @return the nome cliente
	 */
	public String getNomeCliente() {
		return nome;
	}

	/**
	 * Define o nome do cliente.
	 *
	 * @param nomeCliente the new nome cliente
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nome = nomeCliente;
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
}
