package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class CompraDetalle {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int compraId;
	private int libroId;
	private double precio;
	private int cantidad;
	private double subtotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@OneToOne
	@JoinColumn(name="libroId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public Libro libro;
}
