package com.biblioteca.biblioteca.model;

public class Biblioteca {
	private int id;
	private int numero;
	private int facultadId;
	private int fechaCreacion;

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int Numero) {
        this.numero = Numero;
    }

    public int getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(int FacultadId) {
        this.facultadId = FacultadId;
    }

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(int FechaCreacion) {
        this.fechaCreacion = FechaCreacion;
    }

	
	
}
