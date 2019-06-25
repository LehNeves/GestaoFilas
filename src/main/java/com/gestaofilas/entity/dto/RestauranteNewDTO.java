package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import com.gestaofilas.entity.TelefoneRestaurante;
import com.gestaofilas.services.validation.RestauranteInsert;

// TODO: Auto-generated Javadoc
/**
 * Classe RestauranteNewDTO.
 */
@RestauranteInsert
public class RestauranteNewDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The razao social. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String razaoSocial;
	
	/** The nome. */
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	/** The cnpj. */
	@NotEmpty(message="Preenchimento obrigatório")
	@CNPJ
	private String cnpj;
	
	/** The email. */
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
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
	
	/** The cidade. */
	private Integer cidade;
	
	/** The telefones. */
	private List<TelefoneRestaurante> telefones = new ArrayList<TelefoneRestaurante>();
	
	/** The ids categoria. */
	private List<Integer> idsCategoria;
	
	/**
	 * Instancia um novo restaurante new DTO.
	 */
	RestauranteNewDTO(){
	}

	/**
	 * Instancia um novo restaurante new DTO.
	 *
	 * @param razaoSocial the razao social
	 * @param nome the nome
	 * @param cnpj the cnpj
	 * @param email the email
	 * @param senha the senha
	 * @param logradouro the logradouro
	 * @param numero the numero
	 * @param complemento the complemento
	 * @param bairro the bairro
	 * @param cep the cep
	 * @param cidade the cidade
	 * @param telefones the telefones
	 * @param idsCategoria the ids categoria
	 */
	public RestauranteNewDTO(String razaoSocial, String nome, String cnpj, String email, String senha,
			String logradouro, String numero, String complemento, String bairro, String cep,
			Integer cidade, List<TelefoneRestaurante> telefones, List<Integer> idsCategoria) {
		super();
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.setTelefones(telefones);
		this.idsCategoria = idsCategoria;
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
	 * Define razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Pega onome.
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
	 * Pega o cnpj.
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
	 * Pega the email.
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
	 * Pega o senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define o senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Pegao logradouro.
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
	 * Pega os ids da categoria.
	 *
	 * @return the ids categoria
	 */
	public List<Integer> getIdsCategoria() {
		return idsCategoria;
	}

	/**
	 * Define os ids da categoria.
	 *
	 * @param idsCategoria the new ids categoria
	 */
	public void setIdsCategoria(List<Integer> idsCategoria) {
		this.idsCategoria = idsCategoria;
	}

	/**
	 * Pega a cidade.
	 *
	 * @return the cidade
	 */
	public Integer getCidade() {
		return cidade;
	}

	/**
	 * Define a cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	/**
	 * Pega o telefones.
	 *
	 * @return the telefones
	 */
	public List<TelefoneRestaurante> getTelefones() {
		return telefones;
	}

	/**
	 * Define o telefones.
	 *
	 * @param telefones the new telefones
	 */
	public void setTelefones(List<TelefoneRestaurante> telefones) {
		this.telefones = telefones;
	}
}
