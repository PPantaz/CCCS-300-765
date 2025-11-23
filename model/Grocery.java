package com.onlinestore.model;

import com.onlinestore.model.Product;
import java.time.LocalDate;

/**
 * Grocery product subclass.
 * Demonstrates inheritance and polymorphism.
 */
public class Grocery extends Product {
    private static final long serialVersionUID = 1L;
    
    private LocalDate expiryDate;
    private boolean isOrganic;

    public Grocery(String id, String name, double price, int stock, 
                  LocalDate expiryDate, boolean isOrganic) {
        super(id, name, price, stock, "Grocery");
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }

    @Override
    public double calculateDiscountedPrice(double discountPercent) {
        // Organic groceries get extra 3% discount
        double extraDiscount = isOrganic ? 3.0 : 0.0;
        return price * (1 - (discountPercent + extraDiscount) / 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("GROCERY PRODUCT");
        System.out.println("═══════════════════════════════════════");
        System.out.println("ID:       " + id);
        System.out.println("Name:     " + name);
        System.out.println("Price:    $" + String.format("%.2f", price));
        System.out.println("Stock:    " + stock);
        System.out.println("Expiry:   " + expiryDate);
        System.out.println("Organic:  " + (isOrganic ? "Yes" : "No"));
        System.out.println("Rating:   " + String.format("%.1f", getAverageRating()) + "");
        System.out.println("═══════════════════════════════════════");
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public boolean isOrganic() { return isOrganic; }
}
