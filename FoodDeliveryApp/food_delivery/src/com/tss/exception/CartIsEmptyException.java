package com.tss.exception;

public class CartIsEmptyException extends RuntimeException {

    public CartIsEmptyException() {
        super("Cart is empty. Please add items before placing an order.");
    }

    public CartIsEmptyException(String message) {
        super(message);
    }
}