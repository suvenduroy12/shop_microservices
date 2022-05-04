package com.microservice.product.controller;

import com.microservice.product.model.Product;
import com.microservice.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
public class ProductControllerTest {
    @MockBean
    private ProductService productService;

    private ProductController productController;

    @BeforeEach
    void setup(){
        productService=mock(ProductService.class);
        productController= new ProductController(productService);
    }


    @Test
    public void addProductTest() {
        //Product product = new Product(1,"Shyam","bananashake",2000);

        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productService.addproduct(product)).thenReturn(product);
        final var responseEntity=productController.addproduct(product);
        assertEquals(CREATED,responseEntity.getStatusCode());
    }

    @Test
    public void updateProductTest() {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productService.addproduct(product)).thenReturn(product);
        final var responseEntity=productController.updateProduct(product);
        assertEquals(OK,responseEntity.getStatusCode());
    }

    @Test
    public void getAllProductTest() {
        Product product = Product.builder()
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        //when(productService.getAll().parallelStream()).thenReturn((Stream<Product>) product);

        when(productService.getAll())
                .thenReturn((List<Product>)
                        Stream.of(product)
                                .collect(Collectors.toList()));
        final var responseEntity=productController.getAllProduct();
        assertEquals(OK,responseEntity.getStatusCode());
    }


    @Test
    public void getProductByIdTest() {
        Product product = Product.builder()

                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productService.getById(3)).thenReturn(product);
        final var responseEntity=productController.getById(3);
        //Product p=productService.getById(3);
        assertEquals(OK,responseEntity.getStatusCode());
        //assertEquals(responseEntity.getBody().getName(),"Suvendu");

    }

    @Test
    public void deleteProductTest() {
        Product product = Product.builder()
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productService.getById(3)).thenReturn(product);
        final var responseEntity=productController.deleteProduct(3);
        assertEquals(responseEntity.getStatusCode(), OK);


    }
/*
    @Test
    public void getAllProductTest() {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();
        when(productService.getAll())
                .thenReturn((List<Product>)
                        Stream.of(product)
                                .collect(Collectors.toList()));

        assertEquals(1, productController.getAllProduct().size());
    }

 */
/*
    @Test
    public void getProductByIdTest() {
        Product product = Product.builder()

                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productService.getById(3)).thenReturn(product);
        assertEquals(product, productController.getById(3));

    }*/


}
