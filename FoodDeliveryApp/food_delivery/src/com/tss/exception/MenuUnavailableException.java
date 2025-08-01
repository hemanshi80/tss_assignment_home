package com.tss.exception;

public class MenuUnavailableException  extends RuntimeException {

    public MenuUnavailableException() {
        super("No food items are available at the moment.");
    }

    public MenuUnavailableException(String message) {
        super(message);
    }
}