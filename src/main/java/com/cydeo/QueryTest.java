package com.cydeo;

import com.cydeo.enums.DiscountType;
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

        System.out.println("Count of the item in cart_item table: " + cartItemRepository.countCartItemBy());
        System.out.println("Items in a specific cart: " + cartItemRepository.findByCartId(452L));
        System.out.println("Items in a specific cart and product: " + cartItemRepository.findByCartIdAndProductNameContains(452L, "Sauce Tomato Pouch"));
        System.out.println("Items in a specific cart without discount: " + cartItemRepository.findByCartIdAndDiscountIdIsNull(3L));

        System.out.println("Cart for a specific discount Type: " + cartRepository.findByDiscountDiscountType(DiscountType.valueOf("RATE_BASED")));
        System.out.println("Cart By Customer: " + cartRepository.findCartByCustomerId(3L));

        System.out.println("Category By Name: " + categoryRepository.findByName("Termite Control"));
        System.out.println("Category By Name: " + categoryRepository.findTop3ByOrderByName());

        System.out.println("Customer By UserName: " + customerRepository.findByUserName("asturton0"));
        System.out.println("Customer By Email: " + customerRepository.findByEmail("asturton0@list-manage.com"));

        System.out.println("Discount Greater than the amount: " + discountRepository.findByDiscountGreaterThan(BigDecimal.valueOf(25)));
        System.out.println("Discount with a specific amount: " + discountRepository.findByDiscountType(DiscountType.valueOf("RATE_BASED")));
        System.out.println("Discount between the given range: " + discountRepository.findByDiscountBetween(BigDecimal.valueOf(25), BigDecimal.valueOf(75)));

        System.out.println("Top 5 orders: " + orderRepository.findTop3ByOrderByTotalPriceDesc());
        System.out.println("Check is there any orders by customer email: " + orderRepository.findByCustomerEmail("asturton0@list-manage.com"));
        System.out.println("Orders that have equal totalPrice and paidPrice: " + orderRepository.findByTotalPriceEqualsPaidPrice());




    }
}
