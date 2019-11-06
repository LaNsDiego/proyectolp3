package com.biblioteca.biblioteca.model;

import com.biblioteca.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Prestamo {
//	@Transient
//	@Autowired
//	private LibroService daoLibro;
	public static final String RESERVADO = "RESERVADO";
	public static final String DEVUELTO = "DEVUELTO";
    public static final String PRESTADO = "PRESTADO";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int usuarioBibliotecariaId;
	private int usuarioId;
	private int libroId;
	private int bibliotecaId;
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

	public int getBiblioteca() {
		return bibliotecaId;
	}

	public void setBiblioteca(int bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}

	@OneToOne
	@JoinColumn(name="libroId",referencedColumnName = "id" , insertable=false,  updatable=false)
	public Libro libro;

	@OneToOne
	@JoinColumn(name="usuarioId",referencedColumnName = "id" , insertable=false,  updatable=false)
	public Usuario usuario;


}
