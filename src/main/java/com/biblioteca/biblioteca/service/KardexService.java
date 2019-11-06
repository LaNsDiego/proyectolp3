package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Kardex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexService extends JpaRepository<Kardex,Integer> {

    Kardex getByBibliotecaIdAndLibroId(int bibliotecaId, int libroId);
}
