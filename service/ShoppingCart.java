package com.onlinestore.service;

import com.onlinestore.model.Product;
import com.onlinestore.exceptions.EmptyCartException;
import java.util.ArrayList;
import java.util.List;

/**
 * Shopping cart service for managing products.
 * ✅ Requirement: Arrays/ArrayLists (has ArrayList<Product>)
 */
public class ShoppingCart {
    private List<Product> products; // ✅ ArrayList for products
    private double discountPercent;

    public ShoppingCart() {
        this.products = new ArrayList<>(); // ✅ ArrayList initialization
        this.discountPercent = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("✅ Added: " + product.getName());
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < products.size()) {
            Product removed = products.remove(index);
            System.out.println("🗑️ Removed: " + removed.getName());
        } else {
            System.out.println("❌ Invalid product index.");
        }
    }

    public void clearCart() {
        products.clear();
        discountPercent = 0.0;
        System.out.println("🗑️ Cart cleared.");
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("❌ Invalid discount percentage.");
            return;
        }
        this.discountPercent = percent;
        System.out.printf("✅ Applied %.1f%% discount.%n", percent);
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (Product product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        return subtotal * (1 - discountPercent / 100.0);
    }

    /**
     * Checkout - throws custom exception if cart is empty.
     * ✅ Exception handling
     */
    public void checkout() throws EmptyCartException {
        if (isEmpty()) {
            throw new EmptyCartException();
        }
        System.out.println("✅ Proceeding to checkout...");
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public int getItemCount() {
        return products.size();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products); // Return copy
    }

    public void displayCart() {
        if (isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
            return;
        }

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("🛒 SHOPPING CART");
        System.out.println("═══════════════════════════════════════");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %-25s $%.2f%n", i + 1, product.getName(), product.getPrice());
        }
        System.out.println("═══════════════════════════════════════");
        System.out.printf("Subtotal:  $%.2f%n", calculateSubtotal());
        if (discountPercent > 0) {
            System.out.printf("Discount:  %.1f%%%n", discountPercent);
        }
        System.out.printf("Total:     $%.2f%n", calculateTotal());
        System.out.println("═══════════════════════════════════════");
    }
}
