package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int usuarioId;
	private int bibliotecaId;
	private int proveedorId;
	private String fechaRegistro;
	private String fechaCompra;
	private double total;
	private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int UsuarioId) {
        this.usuarioId = UsuarioId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int ProveedorId) {
        this.proveedorId = ProveedorId;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.fechaRegistro = FechaRegistro;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.fechaCompra = FechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double Total) {
        this.total = Total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    @OneToOne
    @JoinColumn(name="usuarioId" , referencedColumnName = "id", insertable=false,  updatable=false)
    public Usuario usuario;
}
