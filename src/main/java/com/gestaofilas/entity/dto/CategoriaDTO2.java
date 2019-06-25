package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Categoria;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoriaDTO2.
 */
public class CategoriaDTO2 implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/**
	 * Instancia uma nova categoria DTO 2.
	 */
	public CategoriaDTO2() {
	}
	
	/**
	 * Instancia uma nova categoria DTO 2.
	 *
	 * @param obj the obj
	 */
	public CategoriaDTO2(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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
