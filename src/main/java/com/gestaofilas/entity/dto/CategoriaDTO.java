package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.Restaurante;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private List<RestauranteDTO> restaurantes = new ArrayList<>(); 
	
	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	public CategoriaDTO(Categoria obj, List<Restaurante> restaurantes) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.setRestaurantes(restaurantes.stream().map(list -> new RestauranteDTO(list)).collect(Collectors.toList()));
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

	public List<RestauranteDTO> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<RestauranteDTO> restaurantes) {
		this.restaurantes = restaurantes;
	}

}
