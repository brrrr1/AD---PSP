package com.salesianos.ej02ap1.repository;

import com.salesianos.ej02ap1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
