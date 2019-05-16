package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.gestaofilas.entity.EnderecoRestaurante;
import com.gestaofilas.entity.TelefoneRestaurante;
import com.gestaofilas.services.validation.RestauranteUpdate;

@RestauranteUpdate
public class RestauranteUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String razaoSocial;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	
	private List<TelefoneRestaurante> telefonesRestaurante= new ArrayList<>();
	
	private EnderecoRestaurante enderecoRestaurante;
	
	private List<Integer> idsCategorias = new ArrayList<>();
	
	public RestauranteUpdateDTO() {
	}

	public RestauranteUpdateDTO(Integer id, String razaoSocial, String nome, String email, String senha,
			List<Integer> idsCategorias) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idsCategorias = idsCategorias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Integer> getIdsCategorias() {
		return idsCategorias;
	}

	public void setIdsCategorias(List<Integer> idsCategorias) {
		this.idsCategorias = idsCategorias;
	}

	public List<TelefoneRestaurante> getTelefonesRestaurante() {
		return telefonesRestaurante;
	}

	public void setTelefonesRestaurante(List<TelefoneRestaurante> telefonesRestaurante) {
		this.telefonesRestaurante = telefonesRestaurante;
	}

	public EnderecoRestaurante getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	public void setEnderecoRestaurante(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}
}
