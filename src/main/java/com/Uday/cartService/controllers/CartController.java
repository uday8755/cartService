package com.Uday.cartService.controllers;

import com.Uday.cartService.dtos.CartDto;
import com.Uday.cartService.dtos.ItemDto;
import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;
import com.Uday.cartService.exceptions.CartNotFoundException;
import com.Uday.cartService.exceptions.ItemNotFoundException;
import com.Uday.cartService.services.CartService;
import com.Uday.cartService.services.ItemService;
import com.Uday.cartService.utils.DTOToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/greeting")
    public ResponseEntity greetings(){
        return new ResponseEntity("Greetings from services", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCart(@RequestBody CartDto cartDto){
         Cart savedCart = cartService.createCart(DTOToEntityConverter.convertCartDTOToCartEntity(cartDto));
         CartDto savedCartDto = DTOToEntityConverter.convertCartEntityToCartDTO(savedCart);
         return new ResponseEntity(savedCartDto,HttpStatus.CREATED);
    }

    @GetMapping(value = "/{cartId}")
    public ResponseEntity getCartBasedOnId(@PathVariable(name = "cartId") int cartId) throws CartNotFoundException {
        Cart cart = cartService.findByCartId(cartId);
        CartDto cartDto = DTOToEntityConverter.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartDto,HttpStatus.OK);
    }

    @PostMapping(value = "/{cartId}")
    public ResponseEntity addItemToCart(@RequestBody ItemDto itemDto,@PathVariable(name = "cartId") int cartId) throws CartNotFoundException, ItemNotFoundException {
        Item item = itemService.addItemToCart(DTOToEntityConverter.convertItemDtoToItemEntity(itemDto),cartId);
        ItemDto itemDtoResponse = DTOToEntityConverter.convertItemEntityToItemDto(item);
        Cart cart = itemService.getCartOfTheItem(itemDtoResponse.getItemId());
        CartDto cartDto = DTOToEntityConverter.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartDto,HttpStatus.CREATED);
    }




}
