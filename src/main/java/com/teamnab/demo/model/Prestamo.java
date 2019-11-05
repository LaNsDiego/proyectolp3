package com.teamnab.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prestamo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int usuarioBibliotecariaId;
	private int usuarioId;
	private int libroId;
	private int cantidad;
	private String fechaCreacion;
	private String fechaAtencion;
	private String fechaDevolucion;
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioBibliotecariaId() {
		return usuarioBibliotecariaId;
	}

	public void setUsuarioBibliotecariaId(int usuarioBibliotecariaId) {
		this.usuarioBibliotecariaId = usuarioBibliotecariaId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
