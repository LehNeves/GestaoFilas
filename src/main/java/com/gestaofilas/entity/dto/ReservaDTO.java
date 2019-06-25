package com.gestaofilas.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;

// TODO: Auto-generated Javadoc
/**
 * Classe ReservaDTO.
 */
public class ReservaDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;
	
	/** The hora reserva. */
	private Date horaReserva;
	
	/** The estado reserva. */
	private Integer estadoReserva;
	
	/** The restaurante. */
	private RestauranteDTO restaurante;
	
	/** The cliente. */
	private ClienteDTO cliente;
	
	/**
	 * Instancia uma nova reserva DTO.
	 */
	public ReservaDTO() {
	}
	
	/**
	 * Instancia uma nova reserva DTO.
	 *
	 * @param id the id
	 * @param horaReserva the hora reserva
	 * @param estadoReserva the estado reserva
	 * @param restaurante the restaurante
	 * @param cliente the cliente
	 */
	public ReservaDTO(Integer id, Date horaReserva, Integer estadoReserva, Restaurante restaurante, Cliente cliente) {
		super();
		this.id = id;
		this.horaReserva = horaReserva;
		this.estadoReserva = estadoReserva;
		this.restaurante = new RestauranteDTO(restaurante);
		this.cliente = new ClienteDTO(cliente);
	}
	
	/**
	 * Instancia uma nova reserva DTO.
	 *
	 * @param obj the obj
	 */
	public ReservaDTO(Reserva obj) {
		this.id = obj.getId();
		this.horaReserva = obj.getHoraReserva();
		this.estadoReserva = obj.getEstadoReserva().getCod();
		this.restaurante = new RestauranteDTO((Restaurante) obj.getRestaurante());
		this.cliente = new ClienteDTO((Cliente) obj.getCliente());
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
	public RestauranteDTO getRestaurante() {
		return restaurante;
	}

	/**
	 * Define o restaurante.
	 *
	 * @param restaurante the new restaurante
	 */
	public void setRestaurante(RestauranteDTO restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * Pega o cliente.
	 *
	 * @return the cliente
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * Define o cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
