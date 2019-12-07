package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Facultad {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String acronimo;
	public String nombre;
	public int universidadId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUniversidadId() {
		return universidadId;
	}

	public void setUniversidadId(int universidadId) {
		this.universidadId = universidadId;
	}

	@OneToOne
	@JoinColumn(name="universidadId" , referencedColumnName = "id", insertable=false,  updatable=false)
	public Universidad universidad;
}
