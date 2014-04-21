package br.com.scc.entity;

import java.io.Serializable;

public class Car implements Serializable{

	private static final long serialVersionUID = -8633473298015986937L;
	
	private Long idCar;
	private String marca;
	private String nome;
	private Double valor;
	
	public Long getIdCar() {
		return idCar;
	}
	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
