package com.onlinestore.exceptions;

/**
 * Custom exception thrown when a product cannot be found.
 * ✅ Requirement: Custom exception class
 */
public class ProductNotFoundException extends Exception {
    private String productId;

    public ProductNotFoundException(String productId) {
        super("Product not found: " + productId);
        this.productId = productId;
    }

    public ProductNotFoundException(String productId, String message) {
        super(message);
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
