package com.parcial2.procesos.controllers;


import com.parcial2.procesos.models.Articulo;
import com.parcial2.procesos.repository.ArticuloRepository;
import com.parcial2.procesos.services.ArticuloService;
import com.parcial2.procesos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo,@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return articuloService.createArticulo(articulo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }

    }
    @GetMapping("/articulo/{codigo}")
    public ResponseEntity listaPorCodigo(@PathVariable String codigo,@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return articuloService.getArticuloByCodigo(codigo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }

    }

    @PutMapping("/articulo/{codigo}")
    public ResponseEntity modificarArticulo(@PathVariable String codigo, @RequestBody Articulo articulo,@RequestHeader(value = "Authorization") String token) {
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return articuloService.editArticulo(codigo,articulo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }

    }

    @DeleteMapping("/articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo,@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return articuloService.deleteArticuloByCodigo(codigo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }
    }
    @GetMapping("/articulos")
    public ResponseEntity listarArticulo(@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return articuloService.allArticulos();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }

    }


}
