package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.TelefoneCliente;

public class ClienteDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String cpf;
	private EnderecoCliente endereco;
	private List<TelefoneCliente> telefones = new ArrayList<>();
	
	public ClienteDTO2 () {
	}

	public ClienteDTO2(String nome, String email, String cpf, EnderecoCliente endereco,
			List<TelefoneCliente> telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
	}
	
	public ClienteDTO2(Cliente obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
		this.endereco = obj.getEndereco();
		this.telefones = obj.getTelefones();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoCliente getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneCliente> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneCliente> telefones) {
		this.telefones = telefones;
	}
}
