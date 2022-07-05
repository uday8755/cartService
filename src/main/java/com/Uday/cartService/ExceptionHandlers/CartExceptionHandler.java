package com.Uday.cartService.ExceptionHandlers;

import com.Uday.cartService.exceptions.CartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartExceptionHandler {

    @ExceptionHandler(value = CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(){
        return new ResponseEntity("No such Cart found", HttpStatus.BAD_REQUEST);
    }
}
