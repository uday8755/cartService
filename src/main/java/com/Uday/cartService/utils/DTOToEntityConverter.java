package com.Uday.cartService.utils;

import com.Uday.cartService.dtos.CartDto;
import com.Uday.cartService.dtos.ItemDto;
import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;

public class DTOToEntityConverter {
    public static Cart convertCartDTOToCartEntity(CartDto cartDto){
       Cart cart = new Cart();
       cart.setCartId(cartDto.getCartId());
       cart.setCustomerName(cartDto.getCustomerName());
       for(ItemDto itemDto : cartDto.getItemList()){
           cart.getItemList().add(convertItemDtoToItemEntity(itemDto));
       }
       return cart;
    }

    public static Item convertItemDtoToItemEntity(ItemDto itemDto) {
       Item item = new Item();
       item.setItemDesc(itemDto.getItemDesc());
       item.setItemName(itemDto.getItemName());
       item.setCost(itemDto.getCost());
       item.setCategory(itemDto.getCategory());
       item.setItemId(itemDto.getItemId());
       return item;

    }

    public static CartDto convertCartEntityToCartDTO(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setCustomerName(cart.getCustomerName());
        for(Item item : cart.getItemList()){
            cartDto.getItemList().add(convertItemEntityToItemDto(item));
        }
        return cartDto;
    }

    public static ItemDto convertItemEntityToItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDesc(item.getItemDesc());
        itemDto.setItemName(item.getItemName());
        itemDto.setCost(item.getCost());
        itemDto.setCategory(item.getCategory());
        itemDto.setItemId(item.getItemId());
        return itemDto;
    }
}
