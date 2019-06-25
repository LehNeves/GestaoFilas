package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.gestaofilas.entity.EnderecoRestaurante;
import com.gestaofilas.entity.TelefoneRestaurante;
import com.gestaofilas.services.validation.RestauranteUpdate;

// TODO: Auto-generated Javadoc
/**
 * Classe RestauranteUpdateDTO.
 */
@RestauranteUpdate
public class RestauranteUpdateDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;
	
	/** The razao social. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String razaoSocial;
	
	/** The nome. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	/** The email. */
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email
	private String email;
	
	/** The senha. */
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	
	/** The telefones restaurante. */
	private List<TelefoneRestaurante> telefonesRestaurante= new ArrayList<>();
	
	/** The endereco restaurante. */
	private EnderecoRestaurante enderecoRestaurante;
	
	/** The ids categorias. */
	private List<Integer> idsCategorias = new ArrayList<>();
	
	/**
	 * Instancia um novo restaurante update DTO.
	 */
	public RestauranteUpdateDTO() {
	}

	/**
	 * Instancia um novo restaurante update DTO.
	 *
	 * @param id the id
	 * @param razaoSocial the razao social
	 * @param nome the nome
	 * @param email the email
	 * @param senha the senha
	 * @param idsCategorias the ids categorias
	 */
	public RestauranteUpdateDTO(Integer id, String razaoSocial, String nome, String email, String senha,
			List<Integer> idsCategorias) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idsCategorias = idsCategorias;
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
	 * Pega a razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Define a razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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
	 * Pega os ids das categorias.
	 *
	 * @return the ids categorias
	 */
	public List<Integer> getIdsCategorias() {
		return idsCategorias;
	}

	/**
	 * Define os ids das categorias.
	 *
	 * @param idsCategorias the new ids categorias
	 */
	public void setIdsCategorias(List<Integer> idsCategorias) {
		this.idsCategorias = idsCategorias;
	}

	/**
	 * Pega os telefones do restaurante.
	 *
	 * @return the telefones restaurante
	 */
	public List<TelefoneRestaurante> getTelefonesRestaurante() {
		return telefonesRestaurante;
	}

	/**
	 * Define os telefones do restaurante.
	 *
	 * @param telefonesRestaurante the new telefones restaurante
	 */
	public void setTelefonesRestaurante(List<TelefoneRestaurante> telefonesRestaurante) {
		this.telefonesRestaurante = telefonesRestaurante;
	}

	/**
	 * Pega o endereco do restaurante.
	 *
	 * @return the endereco restaurante
	 */
	public EnderecoRestaurante getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	/**
	 * Define o endereco do restaurante.
	 *
	 * @param enderecoRestaurante the new endereco restaurante
	 */
	public void setEnderecoRestaurante(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}
}
