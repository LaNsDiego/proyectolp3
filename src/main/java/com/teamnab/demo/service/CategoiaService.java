package com.teamnab.demo.service;

import com.teamnab.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoiaService extends JpaRepository<Categoria,Integer> {
}
