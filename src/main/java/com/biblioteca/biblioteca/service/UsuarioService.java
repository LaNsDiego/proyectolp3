package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioService extends JpaRepository<Usuario,Integer> {

    Usuario findByCorreoAndClave(String correo , String clave);
}
