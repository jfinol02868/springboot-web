package com.springboot.web.controllers;

import com.springboot.web.models.Product2;
import com.springboot.web.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product2> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product2 findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
