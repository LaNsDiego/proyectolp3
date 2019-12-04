package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.EstadisticaPrestamosPorMes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestamosPorMesService extends JpaRepository<EstadisticaPrestamosPorMes,Integer> {

    @Query(value = "{call PRESTAMOS_POR_MES}" ,nativeQuery = true)
    List<EstadisticaPrestamosPorMes> prestamosPorMes();
}
