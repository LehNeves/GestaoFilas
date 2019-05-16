package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public RestauranteDTO() {
	}
	
	public RestauranteDTO(Restaurante obj) {
		this.setId(obj.getId());
		this.setNome(obj.getNome());
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

	public void setNome(String nomeFantasia) {
		this.nome = nomeFantasia;
	}

}
