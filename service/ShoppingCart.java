package com.onlinestore.service;

import com.onlinestore.model.*;
import java.util.ArrayList;
import java.util.List; 

public class ShoppingCart { // ShoppingCart class definition
    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) { // Method to add a product to the cart
        products.add(product);
    }

    public void displayCart() { // Method to display all products in the cart
        for (Product item : products) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public double calculateTotal() { // Method to calculate the total price of all products in the cart
        double total = 0;
        for (Product item : products) {
            total += item.getPrice();
        }
        return total;
    }

    public void applyDiscountToAll(double percentage) { // Method to apply discount to all discountable products in the cart if necessary
        for (Product item : products) {
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(percentage);
            }
        }
    }

      public Order checkout(Payment payment) {
    // Check if the cart is empty
    if (products == null || products.isEmpty()) {
        System.out.println("Cart is empty!");
        return null;
    }

    // Calculate total price once
    double total = calculateTotal();

    // Process payment
    if (payment.processPayment()) {
        // Create an order with a copy of the products list
        Order order = new Order(new ArrayList<>(products), total, payment);

        // Clear the cart after successful checkout
        products.clear();

        System.out.println("Checkout successful! Total paid: $" + total);
        return order;
    } else {
        System.out.println("Payment failed!");
        return null;
    }
}


       // Find a product by name (used for reviews, etc.)
    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
     // Check if cart is empty
    public boolean isEmpty() {
        return products.isEmpty();

    }

}
