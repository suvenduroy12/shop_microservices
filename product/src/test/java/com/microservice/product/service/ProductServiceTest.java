package com.microservice.product.service;

import com.microservice.product.model.Product;
import com.microservice.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

  @Autowired
//@InjectMocks
    private ProductService productService;


    @MockBean
    private ProductRepository productRepository;

/*
    @BeforeEach
    void setup(){
        productService =new ProductServiceImpl();
    }*/

    @Test
    public void addProductTest() {
        //Product product = new Product(1,"Shyam","bananashake",2000);

        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product, productService.addproduct(product));
    }

    @Test
    public void updateProductTest() {
        //Product product = new Product(1,"Shyam","icecream",2000);

        Product product1 = Product.builder()
                .id(2)
                .name("Roy")
                .product("Coffee")
                .price(100)
                .build();

        Product product2 = Product.builder()
                .id(2)
                .name("S Roy")
                .product("tea")
                .price(100)
                .build();

        when(productRepository.save(product1)).thenReturn(product1);
        assertEquals(product1, productService.updateProduct(product2));
    }


    @Test
    public void getAllProductTest() {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();
        when(productRepository.findAll())
                .thenReturn((List<Product>)
                        Stream.of(product)
                                .collect(Collectors.toList()));

        assertEquals(1, productService.getAll().size());
    }

    @Test
    public void getProductByIdTest() {
        Product product = Product.builder()
                .id(2)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productRepository.getById(2)).thenReturn(product);
        assertEquals(product, productService.getById(2));
    }


    @Test
    public void deleteProductTest() {
        Product product = Product.builder()
                .id(2)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(productRepository.getById(2)).thenReturn(product);
        assertEquals(product, productService.removeProduct(2));
    }
}
