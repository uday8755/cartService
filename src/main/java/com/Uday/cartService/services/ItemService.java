package com.Uday.cartService.services;

import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;
import com.Uday.cartService.exceptions.CartNotFoundException;
import com.Uday.cartService.exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {
    public Item addItemToCart(Item item,int cartId) throws CartNotFoundException;

    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;

    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;
}
