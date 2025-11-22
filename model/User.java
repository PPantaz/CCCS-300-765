package com.onlinestore.model;

import java.io.Serializable;

/**
 * User class to represent a customer.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String email;
    private String address;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.address = "";
    }

    public User(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return String.format("User[%s, %s]", username, email);
    }
}
