package br.com.batepapo.batepapouserssoapwebservices.entity;

import java.io.Serializable;
import java.util.Calendar;

public class ChatKey implements Serializable {

	private static final long serialVersionUID = -3752902490392426182L;
	
	private long codUsuario1;
	private long codUsuario2;
	private Calendar dataHora;
	
	public long getCodUsuario1() {
		return codUsuario1;
	}
	public void setCodUsuario1(long codUsuario1) {
		this.codUsuario1 = codUsuario1;
	}
	public long getCodUsuario2() {
		return codUsuario2;
	}
	public void setCodUsuario2(long codUsuario2) {
		this.codUsuario2 = codUsuario2;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	
	
}
