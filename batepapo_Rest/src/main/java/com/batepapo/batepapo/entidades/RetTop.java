package com.batepapo.batepapo.entidades;

import java.io.Serializable;

public class RetTop implements Serializable {
 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 public RetTop(long contagem, String nomeTopico) {

	this.contagem = contagem;
	this.nomeTopico = nomeTopico;
}
	private long contagem;
	private String nomeTopico;
	 
	public long getContagem() {
		return contagem;
	}
	public void setContagem(long contagem) {
		this.contagem = contagem;
	}
	public String getNometopico() {
		return nomeTopico;
	}
	public void setNometopico(String nometopico) {
		this.nomeTopico = nometopico;
	}
}
