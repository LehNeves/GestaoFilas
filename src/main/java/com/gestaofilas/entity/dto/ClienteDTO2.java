package com.gestaofilas.entity.dto;

import java.io.Serializable;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.TelefoneCliente;

// TODO: Auto-generated Javadoc
/**
 * Classe ClienteDTO2.
 */
public class ClienteDTO2 implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nome. */
	private String nome;
	
	/** The email. */
	private String email;
	
	/** The cpf. */
	private String cpf;
	
	/** The endereco. */
	private EnderecoCliente endereco;
	
	/** The telefone. */
	private TelefoneCliente telefone;
	
	/**
	 * Instancia um novo cliente DTO 2.
	 */
	public ClienteDTO2 () {
	}

	/**
	 * Instancia um novo cliente DTO 2.
	 *
	 * @param nome the nome
	 * @param email the email
	 * @param cpf the cpf
	 * @param endereco the endereco
	 * @param telefones the telefones
	 */
	public ClienteDTO2(String nome, String email, String cpf, EnderecoCliente endereco,
			TelefoneCliente telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefones;
	}
	
	/**
	 * Instancia um novo cliente DTO 2.
	 *
	 * @param obj the obj
	 */
	public ClienteDTO2(Cliente obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
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
	 * @param telefones the new telefone
	 */
	public void setTelefone(TelefoneCliente telefones) {
		this.telefone = telefones;
	}
}
