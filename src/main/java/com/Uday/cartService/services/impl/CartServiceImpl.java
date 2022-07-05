package com.Uday.cartService.services.impl;

import com.Uday.cartService.daos.CartDao;
import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.exceptions.CartNotFoundException;
import com.Uday.cartService.exceptions.UserNameNotFoundException;
import com.Uday.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart createCart(Cart cart) {
        cartDao.delete (cart);
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCartById(int cartId) {
        cartDao.deleteById(cartId);
        return true;
    }

    @Override
    public Cart findByCartId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(()->new CartNotFoundException());

    }

    @Override
    public Cart findCartByCustomerName(String customerName) throws UserNameNotFoundException {
        Cart cart =  cartDao.findByCustomerName(customerName);
        if(cart==null) throw new UserNameNotFoundException();
        return cart;
    }
}
