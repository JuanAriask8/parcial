package com.procesos.negocio.brainer.services;

import com.procesos.negocio.brainer.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface CategoriaService {
    ResponseEntity<Categoria> createCategoria(Categoria categoria);

    ResponseEntity<List<Categoria>> allCategorias();
}
