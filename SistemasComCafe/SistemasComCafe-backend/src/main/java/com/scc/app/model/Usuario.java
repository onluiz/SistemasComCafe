package com.scc.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long idUsuario;
	private String username;
	private String password;
	private Boolean ativo;
	
	@Id
	@SequenceGenerator(allocationSize=1, name="usuario_seq", sequenceName="usuario_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@Column(name = "id_usuario", unique = true, nullable = false)
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ativo")
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
