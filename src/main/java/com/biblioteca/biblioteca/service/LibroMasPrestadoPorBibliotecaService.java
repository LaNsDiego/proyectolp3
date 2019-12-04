package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.EstadisticaLibroMasPrestaPorBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroMasPrestadoPorBibliotecaService extends JpaRepository<EstadisticaLibroMasPrestaPorBiblioteca,Integer> {

    @Query(value = "{call LIBRO_MAS_PRESTADO_POR_BIBLIOTECA}" ,nativeQuery = true)
    List<EstadisticaLibroMasPrestaPorBiblioteca> libroMasPrestadoPorBiblioteca();

    @Query(value = "{call LIBRO_MAS_PRESTADO}" ,nativeQuery = true)
    List<EstadisticaLibroMasPrestaPorBiblioteca> libroMasPrestado();

}
