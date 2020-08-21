package com.product.api.service.impl;

import com.product.api.model.Product;
import com.product.api.repository.ProductRepository;
import com.product.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public HttpStatus save(Product product) {
        if (product != null) {
            productRepository.save(product);
            if (productRepository.findById(product.getRecordId()) != null) {
                return HttpStatus.OK;
            } else {
                return HttpStatus.NO_CONTENT;
            }
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Override
    public HttpStatus update(Long productId, Product product) {
        if (productRepository.findById(productId).get() != null) {
            product.setRecordId(productId);
            return this.save(product);
        } else {
            return HttpStatus.NO_CONTENT;
        }
    }


    @Override
    public HttpStatus delete(Long productId) {
        if (productRepository.findById(productId).get() != null) {
            productRepository.deleteById(productId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NO_CONTENT;
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
