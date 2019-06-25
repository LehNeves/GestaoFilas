package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Estado;
// TODO: Auto-generated Javadoc

/**
 * Classe EstadoDTO.
 */
public class EstadoDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/**
	 * Instancia um novo estado DTO.
	 */
	public EstadoDTO() {
	}

	/**
	 * Instancia um novo estado DTO.
	 *
	 * @param obj the obj
	 */
	public EstadoDTO(Estado obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}