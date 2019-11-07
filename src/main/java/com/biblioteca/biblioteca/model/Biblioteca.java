package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Biblioteca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numero;
	private int facultadId;

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

    public void setFacultadId(int facultadId) {
        this.facultadId = facultadId;
    }

    @OneToOne
    @JoinColumn(name="facultadId" , referencedColumnName = "id", insertable=false,  updatable=false)
    public Facultad facultad;
}
