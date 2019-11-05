package com.teamnab.demo.service;

import com.teamnab.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioService extends JpaRepository<Usuario,Integer> {
}
