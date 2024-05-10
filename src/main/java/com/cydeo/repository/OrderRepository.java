package com.cydeo.repository;

import com.cydeo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //Write a derived query to get top 5 orders which are ordered by total price desc
    //@Query("select distinct o FROM Order o order by o.totalPrice desc limit 3")
    List<Order> findTop3ByOrderByTotalPriceDesc();
    //Write a derived query to check is there any orders by customer email
    List<Order> findByCustomerEmail(String customer_email);

    //Write a JPQL query to get all orders that have equal totalPrice and paidPrice
    @Query("SELECT o FROM Order o where o.totalPrice = o.paidPrice")
    List<Order> findByTotalPriceEqualsPaidPrice();


}
