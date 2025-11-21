package com.onlinestore.model;

public class ProductReview {
    private int rating; // 1–5
    private String comment;

    // Constructor
    public ProductReview(int rating, String comment) {
        if (rating < 1) rating = 1;
        if (rating > 5) rating = 5;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters
    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // Display review
    public void displayReview() {
        System.out.println("Rating: " + rating + " / 5");
        System.out.println("Comment: " + comment);
    }

    @Override
    public String toString() {
        return "Rating: " + rating + "/5, Comment: " + comment;
    }
}

