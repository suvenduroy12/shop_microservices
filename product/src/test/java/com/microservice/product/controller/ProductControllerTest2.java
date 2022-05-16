package com.microservice.product.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.product.model.Product;
import com.microservice.product.service.ProductService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebMvcTest
public class ProductControllerTest2 {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    void shouldAddProductSuccessfully() throws Exception {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        // when(productService.addproduct(product)).thenReturn(product);
        mockMvc.perform(post("/Product/addProduct")
                .contentType("application/json")
                .content(mapper.writeValueAsString(product)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateProductTest() throws Exception {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        //when(productService.updateProduct(product)).thenReturn(product);

        mockMvc.perform(put("/Product/updateProduct")
                .contentType("application/json")
                .content(mapper.writeValueAsString(product)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllProductTest() throws Exception {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        //when(productService.getAll(Product).thenReturn((List<Product>) product);


        List<Product> p = new ArrayList<>(Arrays.asList(product));
        Mockito.when(productService.getAll()).thenReturn(p);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/Product/getProduct")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Suvendu")));
    }

    @Test
    public void getProductByIdTest() throws Exception {
        Product product = Product.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();
        // List<Product> p = new ArrayList<>(Arrays.asList(product));
        Mockito.when(productService.getById(3)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/Product/getProduct/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(3));

        //when(productService.getAll(Product).thenReturn((List<Product>) product);
/*
         mockMvc.perform( MockMvcRequestBuilders
                    .get("/Product/getProduct/{id}", 3)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3));

 */
    }

    @Test
    public void deleteProductByIdTest() throws Exception {
        Product product = Product.builder()
                .id(1)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();
        //List<Product> p = new ArrayList<>(Arrays.asList(product));
        Mockito.when(productService.removeProduct(1)).thenReturn(product);

        mockMvc.perform(delete("/Product/delProduct/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
