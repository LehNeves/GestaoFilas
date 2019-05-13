package com.gestaofilas.entity.enums;

public enum EstadoReserva {
	PENDENTE(1, "Pendente"),
	ACEITO(2, "Aceito"),
	CANCELADO(3, "Cancelado"),
	RECUSADO(4, "Recusado");
	
	private int cod;
	private String descricao;
	
	private EstadoReserva(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
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
