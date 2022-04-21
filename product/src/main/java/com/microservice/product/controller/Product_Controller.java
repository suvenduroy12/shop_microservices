package com.microservice.product.controller;

import java.util.List;

import javax.validation.Valid;

import com.microservice.product.model.Product;
import com.microservice.product.service.Product_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Product")
public class Product_Controller {
    @Autowired
    private Product_service product_service;

   @GetMapping("/{id}")
   //@RequestMapping("{id}")
    public Product getById(@PathVariable int id) {
        return product_service.getById(id);
    }

    @PostMapping("/addProduct")
    //@ResponseStatus(HttpStatus.ACCEPTED)

    public Product addproduct(@Valid @RequestBody Product product)
    {
     return product_service.addproduct(product);
    }


    @GetMapping("/getProduct")
    public List<Product> getcheckout()
    {
        return product_service.getAll();
    }
}
