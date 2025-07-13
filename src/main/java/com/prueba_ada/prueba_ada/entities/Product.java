package com.prueba_ada.prueba_ada.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "productsdb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Nombre;
    private String Descripcion;
    private Double Precio;

    // Getters
    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public Double getPrecio() {
        return Precio;
    }

    // Setters
    public void setId(Long id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }
}
