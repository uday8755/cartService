package com.Uday.cartService.daos;

import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,Integer> {
    public List<Item> findItemsByCart(Cart cart);

}
