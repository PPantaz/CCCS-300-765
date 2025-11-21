package com.onlinestore.model;

// Main Class to Simulate Payments
public class PaymentProcessor {
    public static void main(String[] args) {
        // Process Credit Card Payment
        Payment creditCardPayment = new CreditCardPayment(150.75, "1234567812345678");
        boolean creditCardSuccess = creditCardPayment.processPayment();
        System.out.println("Credit Card Payment Success: " + creditCardSuccess);

        // Process PayPal Payment
        Payment payPalPayment = new PayPalPayment(89.99, "user@example.com");
        boolean payPalSuccess = payPalPayment.processPayment();
        System.out.println("PayPal Payment Success: " + payPalSuccess);

        // Process invalid Credit Card Payment
        Payment invalidCreditCardPayment = new CreditCardPayment(200.00, "1234");
        boolean invalidCreditCardSuccess = invalidCreditCardPayment.processPayment();
        System.out.println("Invalid Credit Card Payment Success: " + invalidCreditCardSuccess);
    }
}
