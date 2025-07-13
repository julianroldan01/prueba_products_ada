package com.prueba_ada.prueba_ada.controller;

import com.prueba_ada.prueba_ada.Dto.ProductDTO;
import com.prueba_ada.prueba_ada.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    // 🔧 Constructor manual para inicializar el service
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO dto) {
        var entity = ProductDTO.Mapper.toEntity(dto);
        var saved = service.save(entity);
        var response = ProductDTO.Mapper.toDTO(saved);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        var product = service.findByIdOrThrow(id);
        return ResponseEntity.ok(ProductDTO.Mapper.toDTO(product));
    }
}
