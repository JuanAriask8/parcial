package com.parcial2.procesos.services;

import com.parcial2.procesos.models.Articulo;
import com.parcial2.procesos.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ArticuloService {
    ResponseEntity<Articulo> createArticulo(Articulo articulo);

    ResponseEntity<Articulo> getArticuloByCodigo(String codigo);

    ResponseEntity<Articulo> editArticulo(String codigo, Articulo articulo);

    ResponseEntity<Articulo> deleteArticuloByCodigo(String codigo);

    ResponseEntity<List<Articulo>> allArticulos();
}
