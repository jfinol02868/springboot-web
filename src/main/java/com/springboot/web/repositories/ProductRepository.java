package com.springboot.web.repositories;

import com.springboot.web.models.Product2;

import java.util.List;

public interface ProductRepository {

    public List<Product2> findAll();

    public Product2 findById(Long id);
}
