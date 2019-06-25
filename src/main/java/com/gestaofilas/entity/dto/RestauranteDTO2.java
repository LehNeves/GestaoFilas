package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gestaofilas.entity.EnderecoRestaurante;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.TelefoneRestaurante;

// TODO: Auto-generated Javadoc
/**
 * Classe RestauranteDTO2.
 */
public class RestauranteDTO2 implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;
	
	/** The razao social. */
	private String razaoSocial;
	
	/** The nome. */
	private String nome;
	
	/** The cnpj. */
	private String cnpj;
	
	/** The email. */
	private String email;
	
	/** The endereco restaurante. */
	private EnderecoRestaurante enderecoRestaurante;
	
	/** The telefones restaurante. */
	private List<TelefoneRestaurante> telefonesRestaurante = new ArrayList<>();

	/**
	 * Instancia um novo restaurante DTO 2.
	 */
	public RestauranteDTO2() {
	}
	
	/**
	 * Instancia um novo restaurante DTO 2.
	 *
	 * @param obj the obj
	 * @param telefonesRestaurante the telefones restaurante
	 */
	public RestauranteDTO2(Restaurante obj, List<TelefoneRestaurante> telefonesRestaurante) {
		this.id = obj.getId();
		this.razaoSocial = obj.getRazaoSocial();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.enderecoRestaurante = obj.getEndereco();
		this.setTelefonesRestaurante(telefonesRestaurante);
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
	 * Pega o nome fantasia.
	 *
	 * @return the nome fantasia
	 */
	public String getNomeFantasia() {
		return nome;
	}

	/**
	 * Define o nome fantasia.
	 *
	 * @param nomeFantasia the new nome fantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nome = nomeFantasia;
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
	 * Pega o CNPJ.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Define o cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	 * Pega o endereco do restaurante.
	 *
	 * @return the endereco restaurante
	 */
	public EnderecoRestaurante getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	/**
	 * Define o endereço do restaurante.
	 *
	 * @param enderecoRestaurante the new endereco restaurante
	 */
	public void setEnderecoRestaurante(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
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

}
