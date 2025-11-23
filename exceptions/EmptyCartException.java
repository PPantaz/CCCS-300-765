package com.onlinestore.exceptions;

/**
 * Custom exception thrown when attempting to checkout with an empty cart.
 * Requirement: Custom exception class
 */
public class EmptyCartException extends Exception {
    
    public EmptyCartException() {
        super("Cannot checkout: Shopping cart is empty!");
    }

    public EmptyCartException(String message) {
        super(message);
    }
}
