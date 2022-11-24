package com.procesos.negocio.brainer.repository;



import com.procesos.negocio.brainer.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
    Optional<Articulo> findByCodigo(String codigo);

}
