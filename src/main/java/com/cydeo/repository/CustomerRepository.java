package com.cydeo.repository;

import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Write a derived query to get customer by username
    List<Customer> findByUserName(String username);

    //Write a JPQL query to get customer by email
    @Query("select customer from Customer customer where customer.email=?1")
    List<Customer> findByEmail(String email);
}
