package com.onlinestore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderHistory class to track customer orders.
 * ✅ Requirement: Arrays/ArrayLists (has ArrayList<Order>)
 */
public class OrderHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Order> orders; // ✅ ArrayList for orders

    public OrderHistory() {
        this.orders = new ArrayList<>(); // ✅ ArrayList initialization
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders); // Return copy to maintain encapsulation
    }

    public Order getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public int getTotalOrders() {
        return orders.size();
    }

    public double getTotalSpent() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.getTotalAmount();
        }
        return total;
    }

    public void displayOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("📦 No orders yet.");
            return;
        }

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("📦 ORDER HISTORY");
        System.out.println("═══════════════════════════════════════");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.printf("%d. Order %s - $%.2f - %s%n", 
                    i + 1, order.getOrderId(), order.getTotalAmount(), 
                    order.getOrderDate().toLocalDate());
        }
        System.out.println("═══════════════════════════════════════");
        System.out.printf("Total Orders: %d | Total Spent: $%.2f%n", 
                getTotalOrders(), getTotalSpent());
    }
}
