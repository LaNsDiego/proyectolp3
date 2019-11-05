package com.teamnab.demo.service;

import com.teamnab.demo.model.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexService extends JpaRepository<Kardex,Integer> {

    Kardex getByBibliotecaIdAndLibroId(int bibliotecaId , int libroId);
}
