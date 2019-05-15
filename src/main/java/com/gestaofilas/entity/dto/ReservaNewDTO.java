package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class ReservaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Date horaReserva;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer estadoReserva;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer restaurante;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer cliente;
	
	public ReservaNewDTO () {
	}

	public ReservaNewDTO(Date horaReserva, Integer estadoReserva, Integer restaurante, Integer cliente) {
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva;
		this.restaurante = restaurante;
		this.cliente = cliente;
	}

	public Date getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(Date horaReserva) {
		this.horaReserva = horaReserva;
	}

	public Integer getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(Integer estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public Integer getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Integer restaurante) {
		this.restaurante = restaurante;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
}
