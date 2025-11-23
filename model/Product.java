package com.onlinestore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Product class.
 * Requirement: Arrays/ArrayLists (has ArrayList<ProductReview>)
 */
public abstract class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String id;
    protected String name;
    protected double price;
    protected int stock;
    protected String category;
    protected List<ProductReview> reviews; // ArrayList for reviews

    public Product(String id, String name, double price, int stock, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.reviews = new ArrayList<>(); // ArrayList initialization
    }

    // Abstract method for discount calculation
    public abstract double calculateDiscountedPrice(double discountPercent);

    // Display product details
    public abstract void displayDetails();

    public void addReview(ProductReview review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (ProductReview review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public String getCategory() { return category; }
    public List<ProductReview> getReviews() { return reviews; }

    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s %-25s $%-8.2f Stock: %-5d Rating: %.1f",
                id, name, price, stock, getAverageRating());
    }
}
