package com.prueba_ada.prueba_ada.service;

import com.prueba_ada.prueba_ada.entities.Product;
import com.prueba_ada.prueba_ada.exception.BadRequestException;
import com.prueba_ada.prueba_ada.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public Product save(Product product) {
        if (product.getNombre() == null || product.getNombre().isBlank()) {
            throw new BadRequestException("El nombre no puede estar vacío.");
        }
        if (product.getPrecio() == null || product.getPrecio() <= 0) {
            throw new BadRequestException("El precio debe ser mayor a cero.");
        }
        return repo.save(product);
    }

    @Override
    public Product findByIdOrThrow(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Producto no encontrado con ID: " + id));
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new BadRequestException("No se puede eliminar. Producto no encontrado con ID: " + id);
        }
        repo.deleteById(id);
    }
}
