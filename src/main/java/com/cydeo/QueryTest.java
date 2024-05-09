package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QueryTest implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;


    public QueryTest(AddressRepository addressRepository, BalanceRepository balanceRepository,
                     CartItemRepository cartItemRepository, CartRepository cartRepository,
                     CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     DiscountRepository discountRepository, OrderRepository orderRepository,
                     PaymentRepository paymentRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Address Of The With Customer Id : " + addressRepository.getAllAddresses(3));
        System.out.println("Address : " + addressRepository.findTop3ByNameStartingWith("Home"));
        System.out.println("Top 3 Address of that email: " + addressRepository.findDistinctTop3ByCustomerEmail("elawie26@exblog.jp"));

        System.out.println("Top 5 Balance: " + balanceRepository.findDistinctTop5ByAmountIsNotNullOrderByAmountDesc());
        System.out.println("Balance: " + balanceRepository.findByAmountGreaterThanEqual(BigDecimal.valueOf(980)));
        System.out.println("Balance: " + balanceRepository.findByAmountLessThanEqual(BigDecimal.valueOf(50)));




    }
}
