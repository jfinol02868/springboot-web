package com.springboot.web.services;

import com.springboot.web.models.Product2;

import java.util.List;

public interface ProductService {

    public List<Product2> findAll();

    public Product2 findById(Long id);
}
