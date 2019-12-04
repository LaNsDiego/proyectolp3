package com.biblioteca.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EstadisticaPrestamosPorDia {
    @Id
    private int uid;
    private int total;
    private int anio;
    private int mes;
    private int dia;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
