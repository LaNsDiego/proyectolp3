package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Kardex {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int libroId;
	private String ruc;
	private String razonSocial;
	private double total;
	private int cantidad;
	private int bibliotecaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getBibliotecaId() {
		return bibliotecaId;
	}

	public void setBibliotecaId(int bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}

	@OneToOne
	@JoinColumn(name="libroId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public Libro libro;

	@OneToOne
	@JoinColumn(name="bibliotecaId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public Biblioteca biblioteca;
}
