package com.microservice.product.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.microservice.product.model.Product;
import com.microservice.product.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAll());
    }


    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        ResponseEntity<Product> response = null;
        Product product = productService.getById(id);
        if (product == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            response = new ResponseEntity<>(product, HttpStatus.OK);

        }
        return response;

    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addproduct(@Valid @RequestBody Product product) {
        product= productService.addproduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)  {

        ResponseEntity<Product> response = null;
        if (product == null) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            product = productService.updateProduct(product);
            response = new ResponseEntity<>(product, HttpStatus.OK);

        }
        return response;
    }



    @DeleteMapping("delProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        
        productService.removeProduct(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }


}
