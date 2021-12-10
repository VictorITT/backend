package com.project.backend.service;

import com.project.backend.model.Product;

import java.util.Optional;

public interface ProductsService {
    Optional<Product> getByName(String nombre);
    Optional<Product> getOne(int id);
    boolean existsByName(String nombre);
    boolean existsById(int id);
    void delete(int id);
    void  save(Product product);
}
