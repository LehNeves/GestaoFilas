package com.gestaofilas.entity.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Perfil.
 */
public enum Perfil {
	
	/** The admin. */
	ADMIN(1, "ROLE_ADMIN"),
	
	/** The cliente. */
	CLIENTE(2, "ROLE_CLIENTE"),
	
	/** The restaurante. */
	RESTAURANTE(3, "ROLE_RESTAURANTE");
	
	/** The cod. */
	private int cod;
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instancia um novo perfil.
	 *
	 * @param cod the cod
	 * @param descricao the descricao
	 */
	private Perfil(int cod, String descricao) {
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
	 * @return the perfil
	 */
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
