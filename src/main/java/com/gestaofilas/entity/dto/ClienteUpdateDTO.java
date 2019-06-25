package com.gestaofilas.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.TelefoneCliente;

// TODO: Auto-generated Javadoc
/**
 * Classe ClienteUpdateDTO.
 */
public class ClienteUpdateDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;
	
	/** The nome. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	/** The email. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String email;
	
	/** The senha. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	
	/** The endereco. */
	private EnderecoCliente endereco;
	
	/** The telefone. */
	private TelefoneCliente telefone;
	
	/**
	 * Instancia um novo cliente update DTO.
	 */
	public ClienteUpdateDTO() {
	}
	
	/**
	 * Instancia um novo cliente update DTO.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param email the email
	 * @param senha the senha
	 * @param endereco the endereco
	 * @param telefone the telefone
	 */
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

	/**
	 * Pega o id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Define o id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * Pega o endereco.
	 *
	 * @return the endereco
	 */
	public EnderecoCliente getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}

	/**
	 * Pega o telefone.
	 *
	 * @return the telefone
	 */
	public TelefoneCliente getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(TelefoneCliente telefone) {
		this.telefone = telefone;
	}
}
