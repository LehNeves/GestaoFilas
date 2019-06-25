package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.enums.Perfil;

// TODO: Auto-generated Javadoc
/**
 * Classe Usuario.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	/** The email. */
	protected String email;
	
	/** The senha. */
	@JsonIgnore
	protected String senha;
	
	/** The perfis. */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	/**
	 * Instancia um novo usuario.
	 */
	public Usuario() {
	}

	/**
	 * Instancia um novo usuario.
	 *
	 * @param id the id
	 * @param email the email
	 * @param senha the senha
	 */
	public Usuario(Integer id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
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
	 * Pega os perfis.
	 *
	 * @return the perfis
	 */
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	/**
	 * Adiciona o perfil.
	 *
	 * @param perfil the perfil
	 */
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
}
