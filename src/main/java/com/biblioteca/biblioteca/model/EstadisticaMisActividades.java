package com.biblioteca.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EstadisticaMisActividades {

    @Id
    private int usuarioId;
    private int total;
    private int mes;
    private int anio;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
