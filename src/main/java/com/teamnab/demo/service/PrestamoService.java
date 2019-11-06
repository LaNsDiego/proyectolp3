package com.teamnab.demo.service;

import com.teamnab.demo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoService extends JpaRepository<Prestamo,Integer> {

    List<Prestamo> findAllByUsuarioIdAndEstado(int usuarioId ,String estado); // RESERVADO , ATENDIDO , DEVUELTO
}
