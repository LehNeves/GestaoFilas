package com.gestaofilas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestaofilas.entity.dto.RestauranteNewDTO;
import com.gestaofilas.entity.enums.TipoLogradouro;

@Entity
public class EnderecoRestaurante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name="idCidade")
	private Cidade cidade;
	
	public EnderecoRestaurante() {
	}

	public EnderecoRestaurante(Integer id, TipoLogradouro tipoLogradouro, String logradouro, String numero, String complemento, String bairro, String cep) {
		this.id = id;
		this.tipoLogradouro = (tipoLogradouro==null) ? null : tipoLogradouro.getCod();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = (complemento==null) ? null: complemento;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	public EnderecoRestaurante(RestauranteNewDTO obj) {
		this.tipoLogradouro = (obj.getTipoLogradouro()==null) ? null : obj.getTipoLogradouro();
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = (obj.getComplemento()==null) ? null: obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public TipoLogradouro getTipoLogradouro() {
		return TipoLogradouro.toEnum(tipoLogradouro);
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro.getCod();
	}
	
}
