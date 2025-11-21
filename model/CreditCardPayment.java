package com.onlinestore.model;


public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment() {
        if (cardNumber != null && cardNumber.length() == 16) {
            System.out.println("Credit Card Payment of $" + getAmount() + " processed successfully.");
            return true;
        } else {
            System.out.println("Credit Card Payment failed. Invalid card number.");
            return false;
        }
    }
}

