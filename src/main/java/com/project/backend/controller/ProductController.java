package com.project.backend.controller;


import com.project.backend.dto.Message;
import com.project.backend.dto.ProductDto;
import com.project.backend.model.Product;
import com.project.backend.service.impl.ProductServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list(){
        List<Product> list = productServiceImpl.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id){
        if(!productServiceImpl.existsById(id))
            return new ResponseEntity(new Message("Does not exist"), HttpStatus.NOT_FOUND);
        Product product = productServiceImpl.getOne(id).get();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/detailname/{name}")
    public ResponseEntity<Product> getByName(@PathVariable("name") String name){
        if(!productServiceImpl.existsByName(name))
            return new ResponseEntity(new Message("Does not exist"), HttpStatus.NOT_FOUND);
        Product product = productServiceImpl.getByName(name).get();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto){
        if(StringUtils.isBlank(productDto.getName()))
            return new ResponseEntity(new Message("Name is required"), HttpStatus.BAD_REQUEST);
        if(productDto.getPrice()==null || productDto.getPrice()<0 )
            return new ResponseEntity(new Message("Price should be greater than 0"), HttpStatus.BAD_REQUEST);
        if(productServiceImpl.existsByName(productDto.getName()))
            return new ResponseEntity(new Message("Name already exists"), HttpStatus.BAD_REQUEST);
        Product product = new Product(productDto.getName(), productDto.getPrice(), productDto.getImage());
        productServiceImpl.save(product);
        return new ResponseEntity(new Message("Product created"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductDto productDto){
        if(!productServiceImpl.existsById(id))
            return new ResponseEntity(new Message("Does not exist"), HttpStatus.NOT_FOUND);
        if(productServiceImpl.existsByName(productDto.getName()) && productServiceImpl.getByName(productDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("Name already exists"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productDto.getName()))
            return new ResponseEntity(new Message("Name is required"), HttpStatus.BAD_REQUEST);
        if(productDto.getPrice()==null || productDto.getPrice()<0 )
            return new ResponseEntity(new Message("Price should be greater than 0"), HttpStatus.BAD_REQUEST);

        Product product = productServiceImpl.getOne(id).get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productServiceImpl.save(product);
        return new ResponseEntity(new Message("Product updated"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productServiceImpl.existsById(id))
            return new ResponseEntity(new Message("Does not exist"), HttpStatus.NOT_FOUND);
        productServiceImpl.delete(id);
        return new ResponseEntity(new Message("Product deleted"), HttpStatus.OK);
    }


}
