package com.parcial2.procesos.controllers;

import com.parcial2.procesos.models.Articulo;
import com.parcial2.procesos.models.Categoria;
import com.parcial2.procesos.repository.CategoriaRepository;
import com.parcial2.procesos.services.CategoriaService;
import com.parcial2.procesos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/categoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria, @RequestHeader(value = "Authorization") String token){
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return categoriaService.createCategoria(categoria);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }


    }
    @GetMapping("/categorias")
    public ResponseEntity listarCategoria( @RequestHeader(value = "Authorization") String token) {
        try {
            if(jwtUtil.getKey(token) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
            }
            return categoriaService.allCategorias();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token no valido");
        }

    }

}
