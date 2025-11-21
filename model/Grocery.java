package com.onlinestore.model;

public class Grocery extends Product implements Discountable {
    
    public Grocery(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Grocery";
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = getPrice() * percentage / 100;
        setPrice(getPrice() - discountAmount);
    }
    
}