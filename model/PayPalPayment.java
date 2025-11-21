package com.onlinestore.model;
public class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment() {
        // Simulate PayPal payment processing
        if (email != null && email.contains("@")) {
            System.out.println("PayPal Payment of $" + getAmount() + " processed successfully.");
            return true;
        } else {
            System.out.println("PayPal Payment failed. Invalid email address.");
            return false;
        }
    }
}