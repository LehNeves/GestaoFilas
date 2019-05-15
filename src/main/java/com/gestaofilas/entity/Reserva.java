package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaofilas.entity.enums.EstadoReserva;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date horaReserva;
	private Integer estadoReserva;
	
	@ManyToOne
	@JoinColumn(name="idRestaurante")
	private Restaurante restaurante;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	public Reserva(){
	}

	public Reserva(Integer id, Date horaReserva, EstadoReserva estadoReserva) {
		super();
		this.id = id;
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva.getCod();
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

	public EstadoReserva getEstadoReserva() {
		return EstadoReserva.toEnum(estadoReserva);
	}

	public void setEstadoReserva(EstadoReserva estadoReserva) {
		this.estadoReserva = estadoReserva.getCod();
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
