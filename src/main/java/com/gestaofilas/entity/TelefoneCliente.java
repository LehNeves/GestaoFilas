package com.gestaofilas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * Classe TelefoneCliente.
 */
@Entity
public class TelefoneCliente implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** The ddd. */
	private Integer ddd;
	
	/** The telefone. */
	private String telefone;
	
	/** The cliente. */
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	/**
	 * Instancia um novo telefone do cliente.
	 */
	public TelefoneCliente() {
	}

	/**
	 * Instancia um novo telefone do cliente.
	 *
	 * @param id the id
	 * @param ddd the ddd
	 * @param telefone the telefone
	 */
	public TelefoneCliente(Integer id, Integer ddd, String telefone) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.telefone = telefone;
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
	 * Pega o ddd.
	 *
	 * @return the ddd
	 */
	public Integer getDdd() {
		return ddd;
	}

	/**
	 * Define o ddd.
	 *
	 * @param ddd the new ddd
	 */
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	/**
	 * Pega o telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Pega o cliente.
	 *
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Define o cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
