package com.Uday.cartService;

import com.Uday.cartService.daos.CartDao;
import com.Uday.cartService.daos.ItemDao;
import com.Uday.cartService.entities.Cart;
import com.Uday.cartService.entities.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CartServiceApplication.class, args);
		System.out.println("hey man");


	}

}
