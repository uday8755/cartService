package com.Uday.cartService.daos;

import com.Uday.cartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
    public Cart findByCustomerName(String name);
}
