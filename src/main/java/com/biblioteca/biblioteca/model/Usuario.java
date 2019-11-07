package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String dni;
	private String codigo;
	private String nombres;
	private String apellidos;
	private String clave;
	private String correo;
	private int rolId;
	private int facultadId;
	private int bibliotecaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(int facultadId) {
        this.facultadId = facultadId;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    @OneToOne
    @JoinColumn(name="rolId" , referencedColumnName = "id", insertable=false,  updatable=false)
    public Rol rol;

    @OneToOne
    @JoinColumn(name="bibliotecaId" , referencedColumnName = "id", insertable=false,  updatable=false)
    public Biblioteca biblioteca;
}
