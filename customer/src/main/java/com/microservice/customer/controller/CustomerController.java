package com.microservice.customer.controller;
import com.microservice.customer.model.Customer;
import com.microservice.customer.service.CustomerService;

import com.thoughtworks.xstream.converters.javabean.PropertyDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.persistence.criteria.checkout;
import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/Customer")
    public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getAllProduct() {
        return ResponseEntity.ok(customerservice.getAllProducts());
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        ResponseEntity<Customer> response = null;
        Customer product = customerservice.getProductById(id);
        if (product == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            response = new ResponseEntity<>(product, HttpStatus.OK);

        }
        return response;
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

