package com.gestaofilas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestaofilas.entity.dto.RestauranteNewDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoRestaurante.
 */
@Entity
public class EnderecoRestaurante implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** The logradouro. */
	private String logradouro;
	
	/** The numero. */
	private String numero;
	
	/** The complemento. */
	private String complemento;
	
	/** The bairro. */
	private String bairro;
	
	/** The cep. */
	private String cep;
	
	/** The cidade. */
	@ManyToOne
	@JoinColumn(name="idCidade")
	private Cidade cidade;
	
	/**
	 * Instância um novo endereco do restaurante.
	 */
	public EnderecoRestaurante() {
	}

	/**
	 * Instância um novo endereco do restaurante.
	 *
	 * @param id the id
	 * @param logradouro the logradouro
	 * @param numero the numero
	 * @param complemento the complemento
	 * @param bairro the bairro
	 * @param cep the cep
	 */
	public EnderecoRestaurante(Integer id, String logradouro, String numero, String complemento, String bairro, String cep) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = (complemento==null) ? null: complemento;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	/**
	 * Instância um novo endereco do restaurante.
	 *
	 * @param obj the obj
	 */
	public EnderecoRestaurante(RestauranteNewDTO obj) {
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = (obj.getComplemento()==null) ? null: obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
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
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Define a cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
