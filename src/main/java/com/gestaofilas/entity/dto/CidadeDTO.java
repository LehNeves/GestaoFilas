package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Cidade;
// TODO: Auto-generated Javadoc

/**
 * Classe CidadeDTO.
 */
public class CidadeDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/**
	 * Instancia uma nova cidade DTO.
	 */
	public CidadeDTO() {
	}

	/**
	 * Instancia uma nova cidade DTO.
	 *
	 * @param obj the obj
	 */
	public CidadeDTO(Cidade obj) {
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