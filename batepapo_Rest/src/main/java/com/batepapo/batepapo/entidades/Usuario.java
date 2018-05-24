package com.batepapo.batepapo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "codUsuario", name = "pk_usuario"))
public class Usuario implements Serializable{

	private static final long serialVersionUID = -4290262452288506612L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codUsuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="ipaddress")
	private String iPaddress;
	
	public long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(long id) {
		this.codUsuario = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getiPaddress() {
		return iPaddress;
	}
	public void setiPaddress(String iPaddress) {
		this.iPaddress = iPaddress;
	}
	
	
}	
