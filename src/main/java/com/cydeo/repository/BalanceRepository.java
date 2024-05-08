package com.cydeo.repository;

import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a native query to get top 5 max balance

    //Write a derived query to get all balances greater than or equal to specific balance amount

    //Write a native query to get all balances less than specific balance amount
}
