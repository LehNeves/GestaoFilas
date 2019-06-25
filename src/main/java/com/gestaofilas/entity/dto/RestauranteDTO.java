package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Restaurante;

// TODO: Auto-generated Javadoc
/**
 * Classe RestauranteDTO.
 */
public class RestauranteDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/**
	 * Instancia um novo restaurante DTO.
	 */
	public RestauranteDTO() {
	}
	
	/**
	 * Instancia um novo restaurante DTO.
	 *
	 * @param obj the obj
	 */
	public RestauranteDTO(Restaurante obj) {
		this.setId(obj.getId());
		this.setNome(obj.getNome());
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
	 * @param nomeFantasia the new nome
	 */
	public void setNome(String nomeFantasia) {
		this.nome = nomeFantasia;
	}

}
