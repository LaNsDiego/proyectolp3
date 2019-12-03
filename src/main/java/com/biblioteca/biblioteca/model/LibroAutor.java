package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class LibroAutor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int libroId;
	private int autorId;

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

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	@OneToOne
	@JoinColumn(name="autorId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public Autor autor;
}
