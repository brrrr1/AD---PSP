package com.salesianos.ej02ap1.repository;

import com.salesianos.ej02ap1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
