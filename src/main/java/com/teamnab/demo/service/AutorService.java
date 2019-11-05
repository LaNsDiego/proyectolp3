package com.teamnab.demo.service;


import com.teamnab.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorService extends JpaRepository<Autor,Integer> {
}
