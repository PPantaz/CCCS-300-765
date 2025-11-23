package com.onlinestore.exceptions;

/**
 * Custom exception for invalid payment scenarios.
 * Requirement: Custom exception class
 */
public class InvalidPaymentException extends Exception {
    private String paymentType;
    private String reason;

    public InvalidPaymentException(String message) {
        super(message);
    }

    public InvalidPaymentException(String paymentType, String reason) {
        super("Invalid " + paymentType + " payment: " + reason);
        this.paymentType = paymentType;
        this.reason = reason;
    }

    public InvalidPaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getReason() {
        return reason;
    }
}
