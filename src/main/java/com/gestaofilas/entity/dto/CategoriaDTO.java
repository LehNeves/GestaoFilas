package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.Restaurante;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoriaDTO.
 */
public class CategoriaDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/** The restaurantes. */
	private List<RestauranteDTO> restaurantes = new ArrayList<>(); 
	
	/**
	 * Instancia uma nova categoria DTO.
	 */
	public CategoriaDTO() {
	}
	
	/**
	 * Instancia uma nova categoria DTO.
	 *
	 * @param obj the obj
	 */
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	/**
	 * Instancia uma nova categoria DTO.
	 *
	 * @param obj the obj
	 * @param restaurantes the restaurantes
	 */
	public CategoriaDTO(Categoria obj, List<Restaurante> restaurantes) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.setRestaurantes(restaurantes.stream().map(list -> new RestauranteDTO(list)).collect(Collectors.toList()));
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
	 * Pega os restaurantes.
	 *
	 * @return the restaurantes
	 */
	public List<RestauranteDTO> getRestaurantes() {
		return restaurantes;
	}

	/**
	 * Define os restaurantes.
	 *
	 * @param restaurantes the new restaurantes
	 */
	public void setRestaurantes(List<RestauranteDTO> restaurantes) {
		this.restaurantes = restaurantes;
	}

}
