package com.teamnab.demo.service;

import com.teamnab.demo.model.LibroAutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroAutorService extends JpaRepository<LibroAutor,Integer> {
}
