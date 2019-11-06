package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroService extends JpaRepository<Libro,Integer> {
}
