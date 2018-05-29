package com.batepapo.batepapo.entidades;

import java.io.Serializable;

public class RetChat implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public RetChat (long cont, String nomeUsuario) {
	this.cont = cont;
	this.nomeUsuario = nomeUsuario;
}
	
	private long cont;
	private String nomeUsuario;
	public long getCont() {
		return cont;
	}
	public void setCont(long cont) {
		this.cont = cont;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
}


