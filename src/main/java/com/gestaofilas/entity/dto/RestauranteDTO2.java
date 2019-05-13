package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.EnderecoRestaurante;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.TelefoneRestaurante;

public class RestauranteDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String email;
	private EnderecoRestaurante enderecoRestaurante;
	private List<TelefoneRestaurante> telefonesRestaurante = new ArrayList<>();

	public RestauranteDTO2() {
	}
	
	public RestauranteDTO2(Restaurante obj, List<TelefoneRestaurante> telefonesRestaurante) {
		this.id = obj.getId();
		this.razaoSocial = obj.getRazaoSocial();
		this.nomeFantasia = obj.getNomeFantasia();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.enderecoRestaurante = obj.getEndereco();
		this.setTelefonesRestaurante(telefonesRestaurante);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoRestaurante getEnderecoRestaurante() {
		return enderecoRestaurante;
	}

	public void setEnderecoRestaurante(EnderecoRestaurante enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

	public List<TelefoneRestaurante> getTelefonesRestaurante() {
		return telefonesRestaurante;
	}

	public void setTelefonesRestaurante(List<TelefoneRestaurante> telefonesRestaurante) {
		this.telefonesRestaurante = telefonesRestaurante;
	}

}
