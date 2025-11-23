package com.onlinestore.model;

import com.onlinestore.exceptions.InvalidPaymentException;
import java.io.Serializable;

/**
 * Abstract Payment class.
 * Demonstrates abstraction and polymorphism.
 */
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected double amount;
    protected String transactionId;

    public Payment(double amount) {
        this.amount = amount;
        this.transactionId = generateTransactionId();
    }

    /**
     * Process payment - must be implemented by subclasses.
     * Exception handling with custom exception
     */
    public abstract boolean processPayment() throws InvalidPaymentException;

    /**
     * Get payment details - must be implemented by subclasses.
     */
    public abstract String getPaymentDetails();

    protected String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    public double getAmount() { return amount; }
    public String getTransactionId() { return transactionId; }

    @Override
    public String toString() {
        return String.format("Payment[Amount: $%.2f, ID: %s]", amount, transactionId);
    }
}
