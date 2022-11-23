package com.parcial2.procesos.services;

import com.parcial2.procesos.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface CategoriaService {
    ResponseEntity<Categoria> createCategoria(Categoria categoria);

    ResponseEntity<List<Categoria>> allCategorias();
}
