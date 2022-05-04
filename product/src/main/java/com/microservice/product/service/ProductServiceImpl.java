package com.microservice.product.service;

import com.microservice.product.exception.RecordNotFoundException;
import com.microservice.product.model.Product;
import com.microservice.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addproduct(Product product)
    {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws RecordNotFoundException {
        Optional<Product> optionalProduct=productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            productRepository.save(product);
        }
        else{
            throw new RecordNotFoundException("Product id does not exist");
        }
        return product;
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) throws RecordNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()) {
            return productRepository.getById(id);
        }
        else {
            throw new RecordNotFoundException("Product id does not exist");
        }
    }


    @Override
    public Product removeProduct(int id) throws RecordNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()) {
            Product p=optionalProduct.get();
            productRepository.deleteById(id);
            return p;
        }
        else{
            throw new RecordNotFoundException("Product id does not exist");
        }
    }




}