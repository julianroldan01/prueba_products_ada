package com.prueba_ada.prueba_ada.service;

import com.prueba_ada.prueba_ada.entities.Product;
import com.prueba_ada.prueba_ada.exception.BadRequestException;
import com.prueba_ada.prueba_ada.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductRepository repo;
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        repo = mock(ProductRepository.class);
        service = new ProductServiceImpl(repo);
    }

    @Test
    void save_validProduct_returnsSavedProduct() {
        Product product = new Product();
        product.setNombre("Producto válido");
        product.setDescripcion("Desc");
        product.setPrecio(100.0);

        when(repo.save(any(Product.class))).thenReturn(product);

        Product saved = service.save(product);

        assertNotNull(saved);
        assertEquals("Producto válido", saved.getNombre());
        verify(repo).save(product);
    }

    @Test
    void save_invalidPrice_throwsBadRequest() {
        Product product = new Product();
        product.setNombre("Producto inválido");
        product.setPrecio(-5.0);

        BadRequestException ex = assertThrows(BadRequestException.class, () -> {
            service.save(product);
        });

        assertEquals("El precio debe ser mayor a cero.", ex.getMessage());
        verify(repo, never()).save(any());
    }

    @Test
    void findByIdOrThrow_productExists_returnsProduct() {
        Product product = new Product();
        product.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(product));

        Product found = service.findByIdOrThrow(1L);

        assertEquals(1L, found.getId());
        verify(repo).findById(1L);
    }

    @Test
    void findByIdOrThrow_productNotFound_throwsException() {
        when(repo.findById(999L)).thenReturn(Optional.empty());

        BadRequestException ex = assertThrows(BadRequestException.class, () -> {
            service.findByIdOrThrow(999L);
        });

        assertEquals("Producto no encontrado con ID: 999", ex.getMessage());
        verify(repo).findById(999L);
    }
}
