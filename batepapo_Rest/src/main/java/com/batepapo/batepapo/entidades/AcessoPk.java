package com.batepapo.batepapo.entidades;

import java.io.Serializable;
import java.util.Calendar;

public class AcessoPk implements Serializable{
	private static final long serialVersionUID = -3797833137901504128L;
	private long codUsuario;
	private Calendar dataHora;
	
	public long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	
	
}