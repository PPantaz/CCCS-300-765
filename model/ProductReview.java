package com.onlinestore.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Product review class for customer feedback.
 */
public class ProductReview implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private int rating; // 1-5 stars
    private String comment;
    private LocalDateTime reviewDate;

    public ProductReview(String userName, int rating, String comment) {
        this.userName = userName;
        this.rating = Math.max(1, Math.min(5, rating)); // Ensure 1-5 range
        this.comment = comment;
        this.reviewDate = LocalDateTime.now();
    }

    public String getUserName() { return userName; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public LocalDateTime getReviewDate() { return reviewDate; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %d⭐: %s", 
                reviewDate.toLocalDate(), userName, rating, comment);
    }
}
