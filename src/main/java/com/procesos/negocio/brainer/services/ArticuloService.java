package com.procesos.negocio.brainer.services;

import com.procesos.negocio.brainer.models.Articulo;
import com.procesos.negocio.brainer.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ArticuloService {
    ResponseEntity<Articulo> createArticulo(Articulo articulo);

    ResponseEntity<Articulo> getArticuloByCodigo(String codigo);

    ResponseEntity<Articulo> editArticulo(String codigo, Articulo articulo);

    ResponseEntity<Articulo> deleteArticuloByCodigo(String codigo);

    ResponseEntity<List<Articulo>> allArticulos();
}

