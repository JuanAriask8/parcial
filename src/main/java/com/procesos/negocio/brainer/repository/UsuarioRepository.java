package com.procesos.negocio.brainer.repository;

import com.procesos.negocio.brainer.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    List<Usuario> findAllByNombre(String nombre);
    Usuario findByCorreo(String correo);
}
