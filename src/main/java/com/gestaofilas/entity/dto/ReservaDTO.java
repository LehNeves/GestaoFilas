package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;

public class ReservaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date horaReserva;
	private Integer estadoReserva;
	private RestauranteDTO restaurante;
	private ClienteDTO cliente;
	
	public ReservaDTO() {
	}
	
	public ReservaDTO(Integer id, Date horaReserva, Integer estadoReserva, Restaurante restaurante, Cliente cliente) {
		super();
		this.id = id;
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva;
		this.restaurante = new RestauranteDTO(restaurante);
		this.cliente = new ClienteDTO(cliente);
	}
	
	public ReservaDTO(Reserva obj) {
		this.id = obj.getId();
		this.horaReserva = obj.getHoraReserva();
		this.estadoReserva = obj.getEstadoReserva().getCod();
		this.restaurante = new RestauranteDTO((Restaurante) obj.getRestaurante());
		this.cliente = new ClienteDTO((Cliente) obj.getCliente());
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

	public RestauranteDTO getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteDTO restaurante) {
		this.restaurante = restaurante;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
