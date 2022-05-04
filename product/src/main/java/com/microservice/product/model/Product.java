package com.microservice.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message="please enter your correct name")
   // @JsonIgnoreProperties(value = "name", allowSetters = true)
    private String name;
   @NotNull(message =" Please enter the order")
   //@JsonIgnoreProperties(value = "checkout", allowSetters = true)
    private String product;
    @NotNull(message =" Please enter the price")
    //@JsonIgnoreProperties(value = "price", allowSetters = true)
    @Positive
    private int price;



}