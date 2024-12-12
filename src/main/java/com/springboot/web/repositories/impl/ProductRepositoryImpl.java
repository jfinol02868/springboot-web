package com.springboot.web.repositories.impl;

import com.springboot.web.models.Product2;
import com.springboot.web.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepositoryImpl implements ProductRepository {

    public List<Product2> data;

    public ProductRepositoryImpl() {
        this.data = List.of(
                new Product2(1L, "Product 1", 100L),
                new Product2(2L, "Product 2", 200L),
                new Product2(3L, "Product 3", 300L)
        );
    }

    @Override
    public List<Product2> findAll() {
        return data;
    }

    @Override
    public Product2 findById(Long id) {
        return data.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
