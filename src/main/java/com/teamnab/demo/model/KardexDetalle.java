package com.teamnab.demo.model;

public class KardexDetalle {
	
	public int id;
    private int kardexId;
    private int tipoMovimientoId;
    private int cantidad;
    private double costoUnitario;
    private double costoTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKardexId() {
        return kardexId;
    }

    public void setKardexId(int kardexId) {
        this.kardexId = kardexId;
    }

    public int getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public void setTipoMovimientoId(int tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
