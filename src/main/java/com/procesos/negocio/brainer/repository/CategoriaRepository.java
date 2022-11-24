package com.procesos.negocio.brainer.repository;


import com.procesos.negocio.brainer.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
