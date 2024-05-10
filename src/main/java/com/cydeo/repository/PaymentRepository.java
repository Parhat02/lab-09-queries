package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //Write a native query to find the total sum of all payments made
    @Query(value = "SELECT SUM(paid_price) FROM Payment", nativeQuery = true)
    Long sumPaidPrice();

    //write a native query to find the average amount paid for all payments
    @Query(value = "SELECT avg(paid_price) FROM Payment", nativeQuery = true)
    Long AvgPaidPrice();
}
