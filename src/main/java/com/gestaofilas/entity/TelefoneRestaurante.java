package com.gestaofilas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * Classe TelefoneRestaurante.
 */
@Entity
public class TelefoneRestaurante implements Serializable{
	
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
	
	/** The restaurante. */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idRestaurante")
	private Restaurante restaurante;
	
	/**
	 * Instancia um novo telefone do restaurante.
	 */
	public TelefoneRestaurante() {
	}

	/**
	 * Instancia um novo telefone do restaurante.
	 *
	 * @param id the id
	 * @param ddd the ddd
	 * @param telefone the telefone
	 */
	public TelefoneRestaurante(Integer id, Integer ddd, String telefone) {
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
	 * Pega o restaurante.
	 *
	 * @return the restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * Define o restaurante.
	 *
	 * @param restaurante the new restaurante
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
}
