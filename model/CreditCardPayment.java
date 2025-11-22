package com.onlinestore.model;

import com.onlinestore.exceptions.InvalidPaymentException;

/**
 * Credit Card payment implementation.
 * ✅ Exception handling with custom exception
 */
public class CreditCardPayment extends Payment {
    private static final long serialVersionUID = 1L;
    
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCardPayment(double amount, String cardNumber, 
                            String cardHolderName, String expiryDate) {
        super(amount);
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean processPayment() throws InvalidPaymentException {
        // Validate card details
        if (cardNumber == null || cardNumber.length() < 16) {
            throw new InvalidPaymentException("Credit Card", "Invalid card number");
        }

        if (amount <= 0) {
            throw new InvalidPaymentException("Credit Card", "Amount must be positive");
        }

        // Simulate payment processing
        System.out.println("💳 Processing Credit Card payment...");
        try {
            Thread.sleep(1000); // Simulate processing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ Payment successful!");
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("Credit Card ending in %s - $%.2f", 
                cardNumber.substring(cardNumber.length() - 4), amount);
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return cardNumber;
        }
        String cleaned = cardNumber.replaceAll("\\s+", "");
        int length = cleaned.length();
        return "**** **** **** " + cleaned.substring(length - 4);
    }

    public String getCardNumber() { return cardNumber; }
    public String getCardHolderName() { return cardHolderName; }
    public String getExpiryDate() { return expiryDate; }
}
