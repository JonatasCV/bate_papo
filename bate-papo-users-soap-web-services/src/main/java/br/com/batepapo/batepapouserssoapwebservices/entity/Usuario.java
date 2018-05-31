package br.com.batepapo.batepapouserssoapwebservices.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "codUsuario", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Acesso> acessos = new ArrayList<>();
	
	@OneToMany(mappedBy = "codUsuario1", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Chat> chatUser1;

	@OneToMany(mappedBy = "codUsuario2", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Chat> chatUser2;
	
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
	public List<Acesso> getAcessos() {
		return acessos;
	}
	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}
}
