package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.LibroAutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroAutorService extends JpaRepository<LibroAutor,Integer> {
}
