package com.gestaofilas.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.gestaofilas.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@CPF
	private String cpf;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	private Integer cidadeId;
	
	private Integer ddd;
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone;
	
	public ClienteNewDTO() {
	}

	public ClienteNewDTO(String nome, String email, String cpf, String senha,
			String logradouro, String numero, String complemento, String bairro, String cep,
			Integer cidadeId, Integer ddd, String telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeId = cidadeId;
		this.ddd = ddd;
		this.telefone = telefone;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidade() {
		return cidadeId;
	}

	public void setCidade(Integer cidade) {
		this.cidadeId = cidade;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "ClienteNewDTO [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha
				+ ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", bairro="
				+ bairro + ", cep=" + cep + ", cidade=" + cidadeId + ", ddd=" + ddd + ", telefone=" + telefone + "]";
	}
	
	
}
