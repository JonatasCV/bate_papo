package br.com.batepapo.batepapouserssoapwebservices.entity;

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
@Table(name="pesquisa", uniqueConstraints=@UniqueConstraint(columnNames= {"dataHora", "topico"}, name="pk_pesquisa"))
@IdClass(PesquisaKey.class)
public class Pesquisa {
	
	@Id
	@Column(name="dataHora")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	@Id
	@Column(name="topico")
	private long topico;
	
	public Pesquisa() {
		
	}
	
	public Pesquisa(long topico, Calendar dataHora) {
		this.dataHora = dataHora;
		this.topico = topico;
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
