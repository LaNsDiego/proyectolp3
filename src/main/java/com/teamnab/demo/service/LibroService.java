package com.teamnab.demo.service;

import com.teamnab.demo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroService extends JpaRepository<Libro,Integer> {
}
