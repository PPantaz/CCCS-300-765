package com.onlinestore.model;

public class Clothing extends Product implements Discountable {
    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = getPrice() * percentage / 100;
        setPrice(getPrice() - discountAmount);
    }



}
