package com.springboot.web.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.models.Product2;
import com.springboot.web.repositories.ProductRepository;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository {

    private final List<Product2> data;

    public ProductRepositoryJson(Resource resource) throws IOException {
        data = Arrays.asList(new ObjectMapper().readValue(resource.getInputStream(), Product2[].class));
    }

    @Override
    public List<Product2> findAll() {
        return data;
    }

    @Override
    public Product2 findById(Long id) {
        return data
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
