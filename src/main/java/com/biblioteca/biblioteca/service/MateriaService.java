package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaService extends JpaRepository<Materia,Integer> {
}
