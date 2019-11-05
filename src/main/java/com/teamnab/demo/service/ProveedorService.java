package com.teamnab.demo.service;


import com.teamnab.demo.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorService extends JpaRepository<Proveedor,Integer> {
}
