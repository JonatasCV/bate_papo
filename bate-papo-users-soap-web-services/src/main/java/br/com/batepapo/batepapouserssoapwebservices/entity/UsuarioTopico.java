package br.com.batepapo.batepapouserssoapwebservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuario_topico", uniqueConstraints= @UniqueConstraint(columnNames= {"codUsuario", "idTopico"}, name="pk_usuario_topico"))
@IdClass(UsuarioTopicoKey.class)
public class UsuarioTopico implements Serializable{
	
	private static final long serialVersionUID = 7966759018909122685L;
	@Id
	@Column(name="codUsuario")
	private long codUsuario;
	@Id
	@Column(name="idTopico")
	private long idTopico;
	
	public long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}
	public long getIdTopico() {
		return idTopico;
	}
	public void setIdTopico(long idTopico) {
		this.idTopico = idTopico;
	}

}
