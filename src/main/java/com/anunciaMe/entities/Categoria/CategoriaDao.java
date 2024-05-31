package com.anunciaMe.entities.Categoria;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findById(String id);
    Optional<Categoria> findByNombre(String nombre);

    List<Categoria> findAll();
}
