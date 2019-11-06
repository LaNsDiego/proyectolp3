package com.biblioteca.biblioteca.service;


import com.biblioteca.biblioteca.model.LibroMateria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroMateriaService extends JpaRepository<LibroMateria,Integer> {
}
