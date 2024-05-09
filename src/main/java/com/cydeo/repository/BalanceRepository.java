package com.cydeo.repository;

import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a native query to get top 5 max balance
    @Query(value = "SELECT * FROM Balance Where amount is not null order by amount desc limit 5", nativeQuery = true)
    //@Query("SELECT b FROM Balance b where b.amount is not null order by b.amount desc limit 5")
    List<Balance> findDistinctTop5ByAmountIsNotNullOrderByAmountDesc();

    //Write a derived query to get all balances greater than or equal to specific balance amount
    //@Query("SELECT b from Balance b where b.amount >= ?1")
    //@Query(value = "SELECT * from balance where amount >= ?1", nativeQuery = true)
    List<Balance> findByAmountGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount
    @Query(value = "SELECT * from balance where amount <= ?1", nativeQuery = true)
    List<Balance> findByAmountLessThanEqual(BigDecimal amount);
}
