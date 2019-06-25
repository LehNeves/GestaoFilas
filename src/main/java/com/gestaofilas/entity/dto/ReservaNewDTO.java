package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * Classe ReservaNewDTO.
 */
public class ReservaNewDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The hora reserva. */
	@NotEmpty(message="Preenchimento obrigatório")
	private Date horaReserva;
	
	/** The estado reserva. */
	private Integer estadoReserva;
	
	/** The restaurante. */
	private Integer restaurante;
	
	/** The cliente. */
	private Integer cliente;
	
	/**
	 * Instancia uma nova reserva new DTO.
	 */
	public ReservaNewDTO () {
	}

	/**
	 * Instancia uma nova reserva new DTO.
	 *
	 * @param horaReserva the hora reserva
	 * @param estadoReserva the estado reserva
	 * @param restaurante the restaurante
	 * @param cliente the cliente
	 */
	public ReservaNewDTO(Date horaReserva, Integer estadoReserva, Integer restaurante, Integer cliente) {
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva;
		this.restaurante = restaurante;
		this.cliente = cliente;
	}

	/**
	 * Pega a hora da reserva.
	 *
	 * @return the hora reserva
	 */
	public Date getHoraReserva() {
		return horaReserva;
	}

	/**
	 * Define a hora da reserva.
	 *
	 * @param horaReserva the new hora reserva
	 */
	public void setHoraReserva(Date horaReserva) {
		this.horaReserva = horaReserva;
	}

	/**
	 * Pega o estado da reserva.
	 *
	 * @return the estado reserva
	 */
	public Integer getEstadoReserva() {
		return estadoReserva;
	}

	/**
	 * Define o estado da reserva.
	 *
	 * @param estadoReserva the new estado reserva
	 */
	public void setEstadoReserva(Integer estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	/**
	 * Pega o restaurante.
	 *
	 * @return the restaurante
	 */
	public Integer getRestaurante() {
		return restaurante;
	}

	/**
	 * Define o restaurante.
	 *
	 * @param restaurante the new restaurante
	 */
	public void setRestaurante(Integer restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * Pega o cliente.
	 *
	 * @return the cliente
	 */
	public Integer getCliente() {
		return cliente;
	}

	/**
	 * Define o cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
}
