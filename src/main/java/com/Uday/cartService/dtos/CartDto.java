package com.Uday.cartService.dtos;

import com.Uday.cartService.entities.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private int cartId;

    private String customerName;

    private List<ItemDto> itemList;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDto> itemList) {
        this.itemList = itemList;
    }

    public CartDto(){
        itemList = new ArrayList<>();
    }
}
