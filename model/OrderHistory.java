package com.onlinestore.model;

// OrderHistory class to manage a list of orders
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;
    
    // Constructor
    public OrderHistory() {
        this.orders = new ArrayList<>();
    }
    
    // Add an order to the history
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    // Retrieve all orders
    public List<Order> getOrders() {
        return new ArrayList<>(orders); // Return a copy to maintain encapsulation
    }
    
    
    // Display all orders
    public void viewHistory() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public Product findProductByName(String reviewName) {
        for (Order order : orders) {
            for (Product p: order.getProducts()) {
                if (p.getName().equalsIgnoreCase(reviewName)) {
                    return p;
                }
            }
        }
        return null;
    }


}
