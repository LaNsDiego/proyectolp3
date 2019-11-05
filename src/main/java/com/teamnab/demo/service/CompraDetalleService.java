package com.teamnab.demo.service;

import com.teamnab.demo.model.CompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraDetalleService extends JpaRepository<CompraDetalle,Integer> {
    List<CompraDetalle>findAllByCompraId(int compraId);
}
