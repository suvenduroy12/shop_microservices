package com.microservice.product.service;

import com.microservice.product.model.Product;
import com.microservice.product.repository.Product_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_service {
    public List<Product> getAll;
    @Autowired
    private Product_Repository productRepository;



    public Product addproduct(Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }

}