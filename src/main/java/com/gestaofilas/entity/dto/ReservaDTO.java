package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.Usuario;

public class ReservaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date horaReserva;
	private Integer estadoReserva;
	private Usuario restaurante;
	private Usuario cliente;
	
	public ReservaDTO() {
	}
	
	public ReservaDTO(Integer id, Date horaReserva, Integer estadoReserva, Restaurante restaurante, Cliente cliente) {
		super();
		this.id = id;
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva;
		this.restaurante = restaurante;
		this.cliente = cliente;
	}
	
	public ReservaDTO(Reserva obj) {
		this.id = obj.getId();
		this.horaReserva = obj.getHoraReserva();
		this.estadoReserva = obj.getEstadoReserva().getCod();
		this.restaurante = obj.getRestaurante();
		this.cliente = obj.getCliente();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Usuario getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
