package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.EstadisticaPrestamosPieChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadisticaPrestamosPieChartService extends JpaRepository<EstadisticaPrestamosPieChart,Integer> {

    @Query(value = "{call PRESTAMOS_PIE_CHART}" ,nativeQuery = true)
    List<EstadisticaPrestamosPieChart> prestamosPieChart();
}
