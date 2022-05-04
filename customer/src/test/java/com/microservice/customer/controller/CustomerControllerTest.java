package com.microservice.customer.controller;

import com.microservice.customer.model.Customer;
import com.microservice.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
public class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private CustomerController customerController;


    @Test
    public void getProductByIdTest() {
        Customer product = Customer.builder()
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(customerService.getProductById(3)).thenReturn(product);
        final var responseEntity=customerController.getById(3);
        assertEquals(OK,responseEntity.getStatusCode());

    }

    @Test
    public void getAllProductTest() {
        Customer product = Customer.builder()
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

       // when(customerService.getAllProducts().parallelStream()).thenReturn((Stream<Customer>) product);
        when(customerService.getAllProducts())
                .thenReturn((List<Customer>)
                        Stream.of(product)
                                .collect(Collectors.toList()));
        final var responseEntity=customerController.getAllProduct();
        assertEquals(OK,responseEntity.getStatusCode());
    }
}
