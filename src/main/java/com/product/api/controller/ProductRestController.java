package com.product.api.controller;

import com.product.api.model.Product;
import com.product.api.service.PhotoService;
import com.product.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping(value = "/save/product")
    public HttpStatus saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    public HttpStatus updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
}
