package com.onlinestore.model;


public class Electronics extends Product implements Discountable {
    

    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = getPrice() * percentage / 100;
        setPrice(getPrice() - discountAmount);
    }

}



