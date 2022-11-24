package com.procesos.negocio.brainer.controllers;

import com.procesos.negocio.brainer.models.Usuario;
import com.procesos.negocio.brainer.services.UsuarioService;
import com.procesos.negocio.brainer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity getUsuario(@PathVariable Long id,@RequestHeader(value = "Authorization") String token ) {
        if(jwtUtil.getKey(token) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }
        return usuarioService.getUserById(id);

    }

    @PostMapping("/usuario")
    public ResponseEntity crearUsuario(@Valid @RequestBody  Usuario usuario) {
     return usuarioService.createUser(usuario);

    }

    @GetMapping("/usuarios")
    public ResponseEntity listarUsuario(@RequestHeader(value = "Authorization") String token ) {
    return usuarioService.allUsers();
    }


    @GetMapping("/usuario/nombre/{nombre}")
    public ResponseEntity listaPorNombre(@PathVariable String nombre,@RequestHeader(value = "Authorization") String token ) {
        if(jwtUtil.getKey(token) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }
        return usuarioService.allUsersByName(nombre);
    }



    @PutMapping("/usuario/{id}")
    public ResponseEntity editarUsuario(@PathVariable Long id, @Valid @RequestBody  Usuario usuario,@RequestHeader(value = "Authorization") String token ) {
        if(jwtUtil.getKey(token) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }
         return usuarioService.editUser(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable Long id,@RequestHeader(value = "Authorization") String token ) {
        if(jwtUtil.getKey(token) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }

        return usuarioService.deleteUserById(id);
    }

}
