package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    //Write a derived query to get all cart by specific discount type
    List<Cart> findByDiscountDiscountType(DiscountType discount_discountType);

    //Write a JPQL query to get all cart by customer
    @Query("select c From Cart c where c.customer=(select customer from Customer customer where customer.id=?1)")
    List<Cart> findCartByCustomerId(Long id);
}
