package com.onlinestore.model;

import com.onlinestore.model.Product;

/**
 * Clothing product subclass.
 * Demonstrates inheritance and polymorphism.
 */
public class Clothing extends Product {
    private static final long serialVersionUID = 1L;
    
    private String size;
    private String material;

    public Clothing(String id, String name, double price, int stock, 
                   String size, String material) {
        super(id, name, price, stock, "Clothing");
        this.size = size;
        this.material = material;
    }

    @Override
    public double calculateDiscountedPrice(double discountPercent) {
        // Standard discount for clothing
        return price * (1 - discountPercent / 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("CLOTHING PRODUCT");
        System.out.println("═══════════════════════════════════════");
        System.out.println("ID:       " + id);
        System.out.println("Name:     " + name);
        System.out.println("Size:     " + size);
        System.out.println("Material: " + material);
        System.out.println("Price:    $" + String.format("%.2f", price));
        System.out.println("Stock:    " + stock);
        System.out.println("Rating:   " + String.format("%.1f", getAverageRating()) + "");
        System.out.println("═══════════════════════════════════════");
    }

    public String getSize() { return size; }
    public String getMaterial() { return material; }
}
