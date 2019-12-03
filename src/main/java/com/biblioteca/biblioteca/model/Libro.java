package com.biblioteca.biblioteca.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column (unique = true)
	private String titulo;
	/*=============================*/
	private String edicion;
	@Column (unique = true)
	private String isbn;
	/*=============================*/
	private String resumen;
	private String portada;
	private String idioma;
	private double precio;
	private String editorial;
	private String fechaCreacion;
	private int categoriaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	/* 22-nov-2019 ======Ingresamos el GetAndSet de edicion y isbn ================== */
	public String getEdicion() { return edicion; }

	public void setEdicion(String edicion) {this.edicion = edicion;	}

	public String getIsbn() {return isbn;}

	public void setIsbn(String isbn) {this.isbn = isbn;}
	/* ========================================================== */

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	@OneToMany(orphanRemoval=true, cascade={CascadeType.ALL})
	@JoinColumn(name="libroId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public List<LibroAutor> autores;
}