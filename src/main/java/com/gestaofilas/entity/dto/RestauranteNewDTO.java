package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.List;

public class RestauranteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String nome;
	private String cnpj;
	private String email;
	private String senha;
	
	private Integer tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private Integer cidade;
	
	private Integer ddd;
	private String telefone;
	
	private Integer ddd2;
	private String telefone2;
	
	private List<Integer> idsCategoria;
	
	RestauranteNewDTO(){
	}

	public RestauranteNewDTO(String razaoSocial, String nome, String cnpj, String email, String senha,
			Integer tipoLogradouro, String logradouro, String numero, String complemento, String bairro, String cep,
			Integer cidade, Integer ddd, String telefone, Integer ddd2, String telefone2, List<Integer> idsCategoria) {
		super();
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.ddd = ddd;
		this.telefone = telefone;
		this.ddd2 = ddd2;
		this.telefone2 = telefone2;
		this.idsCategoria = idsCategoria;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public Integer getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(Integer tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
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

	public Integer getDdd2() {
		return ddd2;
	}

	public void setDdd2(Integer ddd2) {
		this.ddd2 = ddd2;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public List<Integer> getIdsCategoria() {
		return idsCategoria;
	}

	public void setIdsCategoria(List<Integer> idsCategoria) {
		this.idsCategoria = idsCategoria;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}
}