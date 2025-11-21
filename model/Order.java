package com.onlinestore.model;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private List<Product> products;
    private double totalAmount;
    private Payment payment;
    private LocalDateTime orderDate;

    public Order(List<Product> products, double totalAmount, Payment payment) {
        this.products = products;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.orderDate = LocalDateTime.now();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void displayOrderDetails() {
        System.out.println("\n🧾 --- ORDER DETAILS ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date: " + orderDate.format(formatter));
        System.out.println("Payment Method: " + payment.getClass().getSimpleName());
        System.out.println("Products:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " : $" + p.getPrice());
        }
        System.out.println("Total Paid: $" + totalAmount);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Order placed on " + orderDate.format(formatter) +
               " | Total: $" + totalAmount +
               " | Payment: " + payment.getClass().getSimpleName();
    }
        
}
