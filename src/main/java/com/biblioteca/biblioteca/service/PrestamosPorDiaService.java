package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.EstadisticaPrestamosPorDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestamosPorDiaService extends JpaRepository<EstadisticaPrestamosPorDia,Integer> {

    @Query(value = "{call PRESTAMOS_POR_DIAS}" ,nativeQuery = true)
    List<EstadisticaPrestamosPorDia> prestamosPorDia();
}
