package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoiaService extends JpaRepository<Categoria,Integer> {
}
