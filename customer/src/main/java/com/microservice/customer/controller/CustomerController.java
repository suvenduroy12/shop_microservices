package com.microservice.customer.controller;
import com.microservice.customer.model.Customer;
import com.microservice.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.persistence.criteria.checkout;
import java.util.List;


    @RestController
    @RequestMapping("/Customer")
    public class CustomerController {

        @Autowired
        private CustomerService customerservice;

        @GetMapping("/getCustomer")
        public List<Customer> getCustomer()
        {
            return customerservice.getAllProducts();
        }

    }
/*@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private BankRestConsumer bankRestConsumer;
    @GetMapping("/allBanks")
    public List<Bank> getAll(){
        return bankRestConsumer.getAllBanks();
    }*/

