package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.CompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraDetalleService extends JpaRepository<CompraDetalle,Integer> {
    List<CompraDetalle>findAllByCompraId(int compraId);
}
