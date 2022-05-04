package com.microservice.customer.service;

import com.microservice.customer.model.Customer;
import com.microservice.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {


    @Autowired
    private CustomerService customerService;


    @MockBean
    private CustomerRepository customerRepository;
    @Test
    public void getAllProductTest() {
       Customer product = Customer.builder()
                .id(3)
                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();
        when(customerRepository.findAll())
                .thenReturn((List<Customer>)
                        Stream.of(product)
                                .collect(Collectors.toList()));

        assertEquals(1, customerService.getAllProducts().size());
    }


    @Test
    public void getProductByIdTest() {
        Customer product = Customer.builder()

                .name("Suvendu")
                .product("Coffee")
                .price(100)
                .build();

        when(customerRepository.getById(3)).thenReturn(product);
        assertEquals(product, customerService.getProductById(3));
    }

}
