package com.prueba_ada.prueba_ada.service;

import com.prueba_ada.prueba_ada.entities.Product;
import java.util.Optional;
import com.prueba_ada.prueba_ada.entities.Product;
import java.util.List;
public interface ProductService {
    Product save(Product product);
    Product findByIdOrThrow(Long id); // Cambiado
    List<Product> findAll();
    void deleteById(Long id);
}
