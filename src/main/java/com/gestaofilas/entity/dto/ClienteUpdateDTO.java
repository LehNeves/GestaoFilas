package com.gestaofilas.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.TelefoneCliente;

public class ClienteUpdateDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	
	private EnderecoCliente endereco;
	
	private TelefoneCliente telefone;
	
	public ClienteUpdateDTO() {
	}
	
	public ClienteUpdateDTO(Integer id, String nome, String email, String senha, EnderecoCliente endereco,
			TelefoneCliente telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
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

	public EnderecoCliente getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

	public TelefoneCliente getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneCliente telefone) {
		this.telefone = telefone;
	}
}
