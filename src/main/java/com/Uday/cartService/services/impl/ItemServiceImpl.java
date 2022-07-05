package com.Uday.cartService.services.impl;

import com.Uday.cartService.daos.CartDao;
import com.Uday.cartService.daos.ItemDao;
import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;
import com.Uday.cartService.exceptions.CartNotFoundException;
import com.Uday.cartService.exceptions.ItemNotFoundException;
import com.Uday.cartService.services.CartService;
import com.Uday.cartService.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CartService cartService;

    @Override
    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException {
         Cart cart = null;
         cart = cartService.findByCartId(cartId);
         item.setCart(cart);
         return itemDao.save(item);
    }

    @Override
    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException {
        Cart cart = cartService.findByCartId(cartId);
        List<Item> items = itemDao.findItemsByCart(cart);
        return items;
    }

    @Override
    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException {
        Item item = itemDao.findById(itemId).orElseThrow(()-> new ItemNotFoundException());
        Cart cart = item.getCart();
        return cart;
    }
}
