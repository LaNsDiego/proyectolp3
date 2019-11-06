package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraService extends JpaRepository<Compra,Integer> {

    List<Compra> findAllByBibliotecaId(int bibliotecaId);
}
