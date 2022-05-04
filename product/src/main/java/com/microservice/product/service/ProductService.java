package com.microservice.product.service;

import com.microservice.product.exception.RecordNotFoundException;
import com.microservice.product.model.Product;

import java.util.List;

public interface ProductService {
    public Product addproduct(Product product);
    public List<Product> getAll();
    public Product getById(int id);
    public Product removeProduct(int id);
    public Product updateProduct(Product product) ;
}
