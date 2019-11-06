package com.biblioteca.biblioteca.service;


import com.biblioteca.biblioteca.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorService extends JpaRepository<Autor,Integer> {
}
