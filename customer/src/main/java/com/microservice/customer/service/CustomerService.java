package com.microservice.customer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.microservice.customer.model.Customer;

@FeignClient(name="Product-Service")
public interface CustomerService {

    @GetMapping("/Product/getProduct")

    public List<Customer> getAllProducts();




/*@FeignClient(name = "BANK-SERVICE")
public interface BankRestConsumer {
    @GetMapping("/getLocation")
    public List<Bank> getAllBanks();
    */

}