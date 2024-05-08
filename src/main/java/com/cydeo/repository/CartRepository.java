package com.cydeo.repository;

import com.cydeo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    //Write a derived query to get all cart by specific discount type

    //Write a JPQL query to get all cart by customer
}
