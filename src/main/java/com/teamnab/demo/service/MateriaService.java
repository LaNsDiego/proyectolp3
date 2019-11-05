package com.teamnab.demo.service;

import com.teamnab.demo.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaService extends JpaRepository<Materia,Integer> {
}
