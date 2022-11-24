package com.procesos.negocio.brainer.controllers;

import com.procesos.negocio.brainer.models.Articulo;
import com.procesos.negocio.brainer.utils.JWTUtil;
import com.procesos.negocio.brainer.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

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
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
            }
            return articuloService.createArticulo(articulo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }

    }
    @GetMapping("/articulo/{codigo}")
    public ResponseEntity listaPorCodigo(@PathVariable String codigo,@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
            }
            return articuloService.getArticuloByCodigo(codigo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }

    }

   /* @PutMapping("/articulo/{codigo}")
    public ResponseEntity modificarArticulo(@PathVariable String codigo, @RequestBody Articulo articulo,@RequestHeader(value = "Authorization") String token) {
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
            }
            return articuloService.editArticulo(codigo,articulo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }

    }*/

    @DeleteMapping("/articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo,@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
            }
            return articuloService.deleteArticuloByCodigo(codigo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }
    }
   /* @GetMapping("/articulos")
    public ResponseEntity listarArticulo(@RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
            }
            return articuloService.allArticulos();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token incorrecto");
        }

    }*/


}