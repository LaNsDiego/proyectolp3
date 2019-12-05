package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.EstadisticaMisActividades;
import com.biblioteca.biblioteca.model.EstadisticaPrestamosPieChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstadisticaMisActividadesService extends JpaRepository<EstadisticaMisActividades,Integer> {
    @Query(value = "{call MI_ACTIVIDAD(:usuario_id)}" ,nativeQuery = true)
    List<EstadisticaMisActividades> misActividades(@Param("usuario_id") int usuarioId);

}
