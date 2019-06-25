package com.gestaofilas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestaofilas.entity.enums.EstadoReserva;

// TODO: Auto-generated Javadoc
/**
 * The Class Reserva.
 */
@Entity
public class Reserva implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** The hora reserva. */
	private Date horaReserva;
	
	/** The estado reserva. */
	private Integer estadoReserva;
	
	/** The restaurante. */
	@ManyToOne
	@JoinColumn(name="idRestaurante")
	private Restaurante restaurante;
	
	/** The cliente. */
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	/**
	 * Instância uma nova reserva.
	 */
	public Reserva(){
	}

	/**
	 * Instância uma nova reserva.
	 *
	 * @param id the id
	 * @param horaReserva the hora reserva
	 * @param estadoReserva the estado reserva
	 */
	public Reserva(Integer id, Date horaReserva, EstadoReserva estadoReserva) {
		super();
		this.id = id;
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva.getCod();
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
	public EstadoReserva getEstadoReserva() {
		return EstadoReserva.toEnum(estadoReserva);
	}

	/**
	 * Define o estado da reserva.
	 *
	 * @param estadoReserva the new estado reserva
	 */
	public void setEstadoReserva(EstadoReserva estadoReserva) {
		this.estadoReserva = estadoReserva.getCod();
	}

	/**
	 * Pega o restaurante.
	 *
	 * @return the restaurante
	 */
	public Usuario getRestaurante() {
		return restaurante;
	}

	/**
	 * Define o restaurante.
	 *
	 * @param restaurante the new restaurante
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * Pega o cliente.
	 *
	 * @return the cliente
	 */
	public Usuario getCliente() {
		return cliente;
	}

	/**
	 * Define o cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
