package com.procesos.negocio.brainer.services;

import com.procesos.negocio.brainer.models.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    ResponseEntity<Usuario> getUserById(Long id);
    ResponseEntity<Usuario> createUser(Usuario usuario);
    ResponseEntity<List<Usuario>> allUsers();
    ResponseEntity<List<Usuario>> allUsersByName(String nombre);
    ResponseEntity<Usuario> editUser(Long id, Usuario usuario);
    ResponseEntity<Usuario> deleteUserById(Long id);
    ResponseEntity login(String correo, String password);
}
