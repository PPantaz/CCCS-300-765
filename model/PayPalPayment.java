package com.onlinestore.model;

import com.onlinestore.exceptions.InvalidPaymentException;

/**
 * PayPal payment implementation.
 * Exception handling with custom exception
 */
public class PayPalPayment extends Payment {
    private static final long serialVersionUID = 1L;
    
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public boolean processPayment() throws InvalidPaymentException {
        // Validate PayPal email
        if (email == null || !email.contains("@")) {
            throw new InvalidPaymentException("PayPal", "Invalid email address");
        }

        if (amount <= 0) {
            throw new InvalidPaymentException("PayPal", "Amount must be positive");
        }

        // Simulate payment processing
        System.out.println("Processing PayPal payment...");
        try {
            Thread.sleep(1000); // Simulate processing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Payment successful!");
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("PayPal (%s) - $%.2f", email, amount);
    }

    public String getEmail() { return email; }
}
