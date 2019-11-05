package com.teamnab.demo.model;

public class KardexDetalle {
	
	public int id;
	private int bibliotecaId;
    private int kardexId;
    private int tipoMovimientoId;
    private int cantidad;
    private double costoUnitario;
    private double costoTotal;


    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int BibliotecaId) {
        this.bibliotecaId = BibliotecaId;
    }

    public int getKardexId() {
        return kardexId;
    }

    public void setKardexId(int KardexId) {
        this.kardexId = KardexId;
    }

    public int getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public void setTipoMovimientoId(int TipoMovimientoId) {
        this.tipoMovimientoId = TipoMovimientoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double CostoUnitario) {
        this.costoUnitario = CostoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double CostoTotal) {
        this.costoTotal = CostoTotal;
    }

    public KardexDetalle(int Id, int BibliotecaId, int KardexId, int TipoMovimientoId, int Cantidad, double CostoUnitario, double CostoTotal, String nombre, String movimiento) {
        this.id = Id;
        this.bibliotecaId = BibliotecaId;
        this.kardexId = KardexId;
        this.tipoMovimientoId = TipoMovimientoId;
        this.cantidad = Cantidad;
        this.costoUnitario = CostoUnitario;
        this.costoTotal = CostoTotal;
    }
	
	
	
}
