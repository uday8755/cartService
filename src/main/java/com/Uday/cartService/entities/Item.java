package com.Uday.cartService.entities;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(length = 512)
    private String itemDesc;

    private String category;

    @Column(nullable = false)
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setCart(Cart cart){this.cart = cart;}

    public Cart getCart(){ return cart;}

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
