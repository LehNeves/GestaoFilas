package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeFantasia;
	
	public RestauranteDTO() {
	}
	
	public RestauranteDTO(Restaurante obj) {
		this.setId(obj.getId());
		this.setNomeFantasia(obj.getNomeFantasia());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
