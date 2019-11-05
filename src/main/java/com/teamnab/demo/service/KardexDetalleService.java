package com.teamnab.demo.service;

import com.teamnab.demo.model.KardexDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexDetalleService  extends JpaRepository<KardexDetalle,Integer> {
}
