package com.onlinestore.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Order class to represent a customer order.
 * ✅ Requirement: Arrays/ArrayLists (has ArrayList<Product>)
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String orderId;
    private List<Product> products; // ✅ ArrayList for products
    private double totalAmount;
    private Payment payment;
    private LocalDateTime orderDate;
    private String status;

    public Order(String orderId, List<Product> products, double totalAmount, Payment payment) {
        this.orderId = orderId;
        this.products = new ArrayList<>(products); // ✅ Create new ArrayList
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public List<Product> getProducts() { return products; }
    public double getTotalAmount() { return totalAmount; }
    public Payment getPayment() { return payment; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════\n");
        sb.append("📦 ORDER DETAILS\n");
        sb.append("═══════════════════════════════════════\n");
        sb.append(String.format("Order ID:   %s\n", orderId));
        sb.append(String.format("Date:       %s\n", orderDate.toLocalDate()));
        sb.append(String.format("Status:     %s\n", status));
        sb.append("\nProducts:\n");
        for (Product product : products) {
            sb.append(String.format("  - %s ($%.2f)\n", product.getName(), product.getPrice()));
        }
        sb.append(String.format("\nTotal:      $%.2f\n", totalAmount));
        sb.append(String.format("Payment:    %s\n", payment.getPaymentDetails()));
        sb.append("═══════════════════════════════════════");
        return sb.toString();
    }
}
