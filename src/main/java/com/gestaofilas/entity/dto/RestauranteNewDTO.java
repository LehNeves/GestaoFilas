package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import com.gestaofilas.entity.TelefoneRestaurante;
import com.gestaofilas.services.validation.RestauranteInsert;

@RestauranteInsert
public class RestauranteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String razaoSocial;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@CNPJ
	private String cnpj;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	private Integer tipoLogradouro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	private Integer cidade;
	
	private List<TelefoneRestaurante> telefones = new ArrayList<TelefoneRestaurante>();
	
	private List<Integer> idsCategoria;
	
	RestauranteNewDTO(){
	}

	public RestauranteNewDTO(String razaoSocial, String nome, String cnpj, String email, String senha,
			Integer tipoLogradouro, String logradouro, String numero, String complemento, String bairro, String cep,
			Integer cidade, List<TelefoneRestaurante> telefones, List<Integer> idsCategoria) {
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
		this.setTelefones(telefones);
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

	public List<TelefoneRestaurante> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneRestaurante> telefones) {
		this.telefones = telefones;
	}
}
