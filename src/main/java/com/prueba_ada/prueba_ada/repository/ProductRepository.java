package com.prueba_ada.prueba_ada.repository;

import com.prueba_ada.prueba_ada.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}

