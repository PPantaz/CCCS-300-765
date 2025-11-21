package com.onlinestore.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private String name; // Name of the product   
    protected double price; // Price of the product
    private List<ProductReview> reviews;

    /**
     * Constructs a Product with the specified name and price.
     *
     * @param name  the name of the product
     * @param price the price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public abstract String getCategory(); // Abstract method to get the category of the product
    public double getPrice() { return price; } // Getter for price
    public String getName() { return name; } // Getter for name
    public void setPrice(double price) { this.price = price; } // Setter for price
    public void setName(String name) { this.name = name; } // Setter for name

   public void displayInfo() {
        System.out.println(getName() + " (" + getCategory() + ") - $" + getPrice());
    }
// Add a review
public void addReview(ProductReview review) {
    reviews.add(review);
}

protected abstract void applyDiscount(double percent);

}


