package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Categoria;

public class CategoriaDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public CategoriaDTO2() {
	}
	
	public CategoriaDTO2(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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

}
