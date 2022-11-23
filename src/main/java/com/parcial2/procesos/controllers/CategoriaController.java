package com.parcial2.procesos.controllers;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import com.example.primer_parcial.repository.CategoriaRepository;
import com.example.primer_parcial.services.CategoriaService;
import com.example.primer_parcial.utils.JWTUtil;
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
