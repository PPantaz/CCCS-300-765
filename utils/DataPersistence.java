package com.onlinestore.utils;

import com.onlinestore.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data persistence utility for saving/loading data to/from files.
 * Requirement: External data persistence (file handling)
 */
public class DataPersistence {

    private static final String PRODUCTS_FILE = "products.dat";
    private static final String ORDERS_FILE = "orders.dat";
    private static final String USERS_FILE = "users.dat";

    /**
     * Save products to file.
     * Requirement: File handling for saved data
     */
    public static boolean saveProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(PRODUCTS_FILE))) {
            oos.writeObject(products);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
            return false;
        }
    }

    /**
     * Load products from file.
     * Requirement: File handling for saved data
     */
    @SuppressWarnings("unchecked")
    public static List<Product> loadProducts() {
        File file = new File(PRODUCTS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(PRODUCTS_FILE))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading products: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Save orders to file.
     * Requirement: File handling for saved data
     */
    public static boolean saveOrders(List<Order> orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ORDERS_FILE))) {
            oos.writeObject(orders);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving orders: " + e.getMessage());
            return false;
        }
    }

    /**
     * Load orders from file.
     * Requirement: File handling for saved data
     */
    @SuppressWarnings("unchecked")
    public static List<Order> loadOrders() {
        File file = new File(ORDERS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ORDERS_FILE))) {
            return (List<Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading orders: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Save user data to file.
     * Requirement: File handling for saved data
     */
    public static boolean saveUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(USERS_FILE))) {
            oos.writeObject(user);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Load user data from file.
     * Requirement: File handling for saved data
     */
    public static User loadUser() {
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(USERS_FILE))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading user: " + e.getMessage());
            return null;
        }
    }

    /**
     * Export cart to text file (alternative persistence method).
     * Requirement: File handling for saved data
     */
    public static boolean exportCartToText(List<Product> products, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== Shopping Cart Export ===");
            writer.println("Date: " + java.time.LocalDateTime.now());
            writer.println();
            
            double total = 0.0;
            for (Product product : products) {
                writer.printf("%-20s $%.2f%n", product.getName(), product.getPrice());
                total += product.getPrice();
            }
            
            writer.println();
            writer.printf("Total: $%.2f%n", total);
            return true;
        } catch (IOException e) {
            System.err.println("Error exporting cart: " + e.getMessage());
            return false;
        }
    }

    /**
     * Check if saved data exists.
     * Requirement: File handling for saved data
     */
    public static boolean hasSavedData() {
        return new File(PRODUCTS_FILE).exists() || 
               new File(ORDERS_FILE).exists() || 
               new File(USERS_FILE).exists();
    }
}
