package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get the count of all cart items
    //@Query(value = "SELECT count(*) from cart_item", nativeQuery = true)
    Integer countCartItemBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCartId(Long cart_id);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "select * from cart_item where cart_id=?1 and product_id = (SELECT id from product where name like '?2')", nativeQuery = true)
    List<CartItem> findByCartIdAndProductNameContains(Long cart_id, String product_name);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select * from cart_item where cart_id=?1 and cart_id in (SELECT id from cart where discount_id is null)", nativeQuery = true)
    List<CartItem> findByCartIdAndDiscountIdIsNull(Long cart_id);

}
