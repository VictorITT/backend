package com.project.backend.service.impl;

import com.project.backend.model.Product;
import com.project.backend.repository.ProductRepository;
import com.project.backend.service.OrdersService;
import com.project.backend.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductsService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    public Optional<Product> getOne(int id){
        return productRepository.findById(id);
    }

    public Optional<Product> getByName(String nombre){
        return productRepository.findByName(nombre);
    }

    public void  save(Product product){
        productRepository.save(product);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return productRepository.existsById(id);
    }

    public boolean existsByName(String nombre){
        return productRepository.existsByName(nombre);
    }
}
