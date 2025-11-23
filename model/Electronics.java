package com.onlinestore.model;

import com.onlinestore.model.Product;

/**
 * Electronics product subclass.
 * Demonstrates inheritance and polymorphism.
 */
public class Electronics extends Product {
    private static final long serialVersionUID = 1L;
    
    private String brand;
    private int warrantyMonths;

    public Electronics(String id, String name, double price, int stock, 
                      String brand, int warrantyMonths) {
        super(id, name, price, stock, "Electronics");
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscountedPrice(double discountPercent) {
        // Electronics get extra 5% discount
        return price * (1 - (discountPercent + 5) / 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("ELECTRONICS PRODUCT");
        System.out.println("═══════════════════════════════════════");
        System.out.println("ID:       " + id);
        System.out.println("Name:     " + name);
        System.out.println("Brand:    " + brand);
        System.out.println("Price:    $" + String.format("%.2f", price));
        System.out.println("Stock:    " + stock);
        System.out.println("Warranty: " + warrantyMonths + " months");
        System.out.println("Rating:   " + String.format("%.1f", getAverageRating()) + "");
        System.out.println("═══════════════════════════════════════");
    }

    public String getBrand() { return brand; }
    public int getWarrantyMonths() { return warrantyMonths; }
}
