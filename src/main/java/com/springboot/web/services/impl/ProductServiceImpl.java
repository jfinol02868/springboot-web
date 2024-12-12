package com.springboot.web.services.impl;

import com.springboot.web.models.Product2;
import com.springboot.web.repositories.ProductRepository;
import com.springboot.web.services.ProductService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {

    public final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product2> findAll() {
        return repository.findAll();
    }

    @Override
    public Product2 findById(Long id){
        return repository.findById(id);
    }
}
