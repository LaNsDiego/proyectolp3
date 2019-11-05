package com.teamnab.demo.service;

import com.teamnab.demo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoService extends JpaRepository<Prestamo,Integer> {
}
