package br.com.batepapo.batepapouserssoapwebservices.entity;

import java.io.Serializable;
import java.util.Calendar;

public class PesquisaKey implements Serializable {
	

	private static final long serialVersionUID = 6902765831485890904L;

	private Calendar dataHora;
	private long topico;
	
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public long getTopico() {
		return topico;
	}
	public void setTopico(long topico) {
		this.topico = topico;
	}
	
	
}
