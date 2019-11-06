package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.KardexDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexDetalleService  extends JpaRepository<KardexDetalle,Integer> {
}
