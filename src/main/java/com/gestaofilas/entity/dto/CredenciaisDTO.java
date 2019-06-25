package com.gestaofilas.entity.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Classe CredenciaisDTO.
 */
public class CredenciaisDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The email. */
	private String email;
	
	/** The senha. */
	private String senha;
	
	/**
	 * Instancia novas credenciais DTO.
	 */
	public CredenciaisDTO() {
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
}
