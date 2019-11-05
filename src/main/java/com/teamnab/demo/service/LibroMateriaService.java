package com.teamnab.demo.service;

import com.teamnab.demo.model.LibroMateria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroMateriaService extends JpaRepository<LibroMateria,Integer> {
}
