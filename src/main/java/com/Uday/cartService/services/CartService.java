package com.Uday.cartService.services;

import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.exceptions.CartNotFoundException;
import com.Uday.cartService.exceptions.UserNameNotFoundException;

public interface CartService {
    public Cart createCart(Cart cart);

    public boolean deleteCartById(int cartId);

    public  Cart findByCartId(int cartId) throws CartNotFoundException;

    public Cart findCartByCustomerName(String userName) throws UserNameNotFoundException;
}
