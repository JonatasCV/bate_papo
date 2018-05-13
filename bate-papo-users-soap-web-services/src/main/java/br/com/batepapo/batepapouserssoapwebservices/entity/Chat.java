package br.com.batepapo.batepapouserssoapwebservices.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="chat", uniqueConstraints=@UniqueConstraint(columnNames= {"codUsuario1", "codUsuario2", "dataHora"},name="pk_chat"))
@IdClass(ChatKey.class)
public class Chat implements Serializable{
	
	private static final long serialVersionUID = 1133717866143271139L;
	@Id
	@Column(name="codUsuario1")
	private long codUsuario1;
	@Id
	@Column(name="codUsuario2")
	private long codUsuario2;
	@Id
	@Column(name="dataHora")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	@Column(name="topico")
	private long topico;
	
	public Chat() {
		
	}
	
	public Chat(long codUsuario1, long codUsuario2, long topico, Calendar dataHora) {
		this.codUsuario1 = codUsuario1;
		this.codUsuario2 = codUsuario2;
		this.topico = topico;
		this.dataHora = dataHora;
	}
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
	public long getTopico() {
		return topico;
	}
	public void setTopico(long topico) {
		this.topico = topico;
	}
}
