package com.microservice.product.repository;
import com.microservice.product.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Product_Repository extends JpaRepository<Product,Integer>
{


}