
package com.microservice.customer.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @NotNull(message = "please enter your correct name")
        private String name;
        @NotNull(message="please enter the orders")
        private String product;
        @NotNull(message =" Please enter the price")
        @Positive
        private int price;


    }