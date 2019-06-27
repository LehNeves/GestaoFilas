package com.gestaofilas.entity.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum EstadoReserva.
 */
public enum EstadoReserva {
	
	/** The pendente. */
	PENDENTE(1, "Pendente"),
	
	/** The aceito. */
	ACEITO(2, "Aceito"),
	
	/** The cancelado. */
	CANCELADO(3, "Cancelado"),
	
	/** The recusado. */
	RECUSADO(4, "Recusado");
	
	/** The cod. */
	private int cod;
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instancia um novo estado da reserva.
	 *
	 * @param cod the cod
	 * @param descricao the descricao
	 */
	private EstadoReserva(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	/**
	 * Pega o codigo.
	 *
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 * Pega a descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao () {
		return descricao;
	}
	
	/**
	 * To enum.
	 *
	 * @param cod the cod
	 * @return the estado reserva
	 */
	public static EstadoReserva toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoReserva x : EstadoReserva.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
