package com.gestaofilas.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.gestaofilas.services.validation.ClienteInsert;

// TODO: Auto-generated Javadoc
/**
 * Classe ClienteNewDTO.
 */
@ClienteInsert
public class ClienteNewDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nome. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	/** The email. */
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	/** The cpf. */
	@NotEmpty(message="Preenchimento obrigatório")
	@CPF
	private String cpf;
	
	/** The senha. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	/** The logradouro. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	/** The numero. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	
	/** The complemento. */
	private String complemento;
	
	/** The bairro. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	
	/** The cep. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	/** The cidade id. */
	private Integer cidadeId;
	
	/** The ddd. */
	private Integer ddd;
	
	/** The telefone. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone;
	
	/**
	 * Instancia um novo cliente novo DTO.
	 */
	public ClienteNewDTO() {
	}

	/**
	 * Instantiates a new cliente new DTO.
	 *
	 * @param nome the nome
	 * @param email the email
	 * @param cpf the cpf
	 * @param senha the senha
	 * @param logradouro the logradouro
	 * @param numero the numero
	 * @param complemento the complemento
	 * @param bairro the bairro
	 * @param cep the cep
	 * @param cidadeId the cidade id
	 * @param ddd the ddd
	 * @param telefone the telefone
	 */
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

	/**
	 * Pega o nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Pega o email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define o email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Pega o cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Define o cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Pega a senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define a senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Pega o logradouro.
	 *
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Define o logradouro.
	 *
	 * @param logradouro the new logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Pega o numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Define o numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Pega o complemento.
	 *
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Define o complemento.
	 *
	 * @param complemento the new complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Pega o bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Define o bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Pega o cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Define o cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Pega a cidade.
	 *
	 * @return the cidade
	 */
	public Integer getCidade() {
		return cidadeId;
	}

	/**
	 * Define a cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(Integer cidade) {
		this.cidadeId = cidade;
	}

	/**
	 * Pega o ddd.
	 *
	 * @return the ddd
	 */
	public Integer getDdd() {
		return ddd;
	}

	/**
	 * Define o ddd.
	 *
	 * @param ddd the new ddd
	 */
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	/**
	 * Pega o telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Transforma em uma string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ClienteNewDTO [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha
				+ ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", bairro="
				+ bairro + ", cep=" + cep + ", cidade=" + cidadeId + ", ddd=" + ddd + ", telefone=" + telefone + "]";
	}
	
	
}
