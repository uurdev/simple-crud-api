package com.product.api.service;

import com.product.api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public HttpStatus save(Product product);

    public HttpStatus update(Long productId,Product product);

    public HttpStatus delete(Long productId);

    public List<Product> getAll();


}
