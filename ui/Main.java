package com.onlinestore.ui;

import com.onlinestore.model.*;
import com.onlinestore.service.*;
import com.onlinestore.utils.*;
import com.onlinestore.exceptions.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Main Online Store Management System.
 * ✅ All 8 requirements implemented
 * 
 * Requirements Checklist:
 * 1. ✅ Arrays/ArrayLists - Product reviews, ShoppingCart, OrderHistory, Order
 * 2. ✅ Custom exceptions - InvalidPaymentException, EmptyCartException, ProductNotFoundException
 * 3. ✅ Recursive methods - RecursiveUtils (7 methods)
 * 4. ✅ Search algorithm - SearchAlgorithms (linear, binary, recursive)
 * 5. ✅ Sort algorithm - SortingAlgorithms (bubble, selection, insertion)
 * 6. ✅ Input validation - InputValidator with robust error recovery
 * 7. ✅ File persistence - DataPersistence (save/load to files)
 * 8. ✅ Multi-option menu - This class with 15 menu options
 */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingCart cart = new ShoppingCart();
    private static OrderHistory orderHistory = new OrderHistory();
    private static List<Product> catalog = new ArrayList<>();
    private static User currentUser = null;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   ONLINE STORE MANAGEMENT SYSTEM       ║");
        System.out.println("║   All Requirements Implemented ✅       ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        initializeStore();
        
        // Try to load saved data
        loadSavedData();
        
        // Main program loop
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = InputValidator.getIntInput(scanner, "\n👉 Enter your choice: ", 1, 15);
            
            try {
                running = handleMenuChoice(choice);
            } catch (Exception e) {
                System.err.println("❌ Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        scanner.close();
        System.out.println("\n👋 Thank you for shopping with us!");
    }

    private static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            MAIN MENU                   ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1.  📋 Browse Products");
        System.out.println("2.  ➕ Add Product to Cart");
        System.out.println("3.  🛒 View Shopping Cart");
        System.out.println("4.  🗑️  Remove Product from Cart");
        System.out.println("5.  💰 Apply Discount");
        System.out.println("6.  💳 Checkout");
        System.out.println("7.  📦 View Order History");
        System.out.println("8.  ⭐ Leave Product Review");
        System.out.println("9.  🔍 Search Products (Algorithms)");
        System.out.println("10. 📊 Sort Products (Algorithms)");
        System.out.println("11. 🔢 Recursive Demos");
        System.out.println("12. 💾 Save All Data");
        System.out.println("13. 📂 Load Saved Data");
        System.out.println("14. 👤 View/Edit User Info");
        System.out.println("15. 🚪 Exit");
    }

    private static boolean handleMenuChoice(int choice) throws EmptyCartException, InvalidPaymentException {
        switch (choice) {
            case 1:
                browseProducts();
                break;
            case 2:
                addProductToCart();
                break;
            case 3:
                viewCart();
                break;
            case 4:
                removeProductFromCart();
                break;
            case 5:
                applyDiscount();
                break;
            case 6:
                checkout();
                break;
            case 7:
                viewOrderHistory();
                break;
            case 8:
                leaveProductReview();
                break;
            case 9:
                searchProductsDemo();
                break;
            case 10:
                sortProductsDemo();
                break;
            case 11:
                recursiveDemo();
                break;
            case 12:
                saveAllData();
                break;
            case 13:
                loadSavedData();
                break;
            case 14:
                manageUserInfo();
                break;
            case 15:
                return false; // Exit
        }
        return true;
    }

    private static void initializeStore() {
        // Initialize user
        if (currentUser == null) {
            System.out.println("\n🎯 Welcome! Let's create your account.");
            String username = InputValidator.getStringInput(scanner, "Enter username: ");
            String email = InputValidator.getEmailInput(scanner, "Enter email: ");
            currentUser = new User(username, email);
            System.out.println("✅ Account created for " + username + "!");
        }

        // Initialize product catalog
        catalog.add(new Electronics("E001", "Laptop", 999.99, 10, "Dell", 24));
        catalog.add(new Electronics("E002", "Smartphone", 699.99, 15, "Samsung", 12));
        catalog.add(new Electronics("E003", "Tablet", 399.99, 20, "Apple", 12));
        catalog.add(new Electronics("E004", "Headphones", 199.99, 25, "Sony", 6));
        catalog.add(new Electronics("E005", "Smartwatch", 299.99, 18, "Apple", 12));
        
        catalog.add(new Clothing("C001", "T-Shirt", 29.99, 50, "M", "Cotton"));
        catalog.add(new Clothing("C002", "Jeans", 59.99, 30, "32", "Denim"));
        catalog.add(new Clothing("C003", "Jacket", 89.99, 20, "L", "Leather"));
        catalog.add(new Clothing("C004", "Sneakers", 79.99, 40, "10", "Canvas"));
        catalog.add(new Clothing("C005", "Dress", 69.99, 25, "M", "Silk"));
        
        catalog.add(new Grocery("G001", "Organic Apples", 4.99, 100, LocalDate.now().plusDays(7), true));
        catalog.add(new Grocery("G002", "Whole Wheat Bread", 3.49, 50, LocalDate.now().plusDays(5), true));
        catalog.add(new Grocery("G003", "Milk", 2.99, 75, LocalDate.now().plusDays(3), false));
        catalog.add(new Grocery("G004", "Organic Eggs", 5.99, 60, LocalDate.now().plusDays(10), true));
        catalog.add(new Grocery("G005", "Orange Juice", 3.99, 45, LocalDate.now().plusDays(7), false));

        System.out.println("✅ Store initialized with " + catalog.size() + " products.");
    }

    private static void browseProducts() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("📋 PRODUCT CATALOG");
        System.out.println("═══════════════════════════════════════");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, catalog.get(i));
        }
        System.out.println("═══════════════════════════════════════");
    }

    private static void addProductToCart() {
        if (catalog.isEmpty()) {
            System.out.println("❌ No products available.");
            return;
        }

        browseProducts();
        int choice = InputValidator.getIntInput(scanner, "\nSelect product number: ", 1, catalog.size());
        Product product = catalog.get(choice - 1);
        cart.addProduct(product);
    }

    private static void viewCart() {
        cart.displayCart();
    }

    private static void removeProductFromCart() {
        if (cart.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
            return;
        }

        cart.displayCart();
        int choice = InputValidator.getIntInput(scanner, "\nSelect product to remove: ", 1, cart.getItemCount());
        cart.removeProduct(choice - 1);
    }

    private static void applyDiscount() {
        if (cart.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
            return;
        }

        double discount = InputValidator.getDoubleInput(scanner, "Enter discount percentage (0-100): ", 0.0);
        if (discount > 100) {
            System.out.println("❌ Discount cannot exceed 100%.");
            return;
        }
        cart.applyDiscount(discount);
    }

    /**
     * Checkout - demonstrates exception handling.
     * ✅ Requirement: Exception handling
     */
    private static void checkout() throws EmptyCartException, InvalidPaymentException {
        // Check if cart is empty - throws EmptyCartException
        cart.checkout();

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("💳 CHECKOUT");
        System.out.println("═══════════════════════════════════════");
        cart.displayCart();

        System.out.println("\nSelect payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int paymentChoice = InputValidator.getIntInput(scanner, "Choice: ", 1, 2);

        Payment payment;
        double total = cart.calculateTotal();

        if (paymentChoice == 1) {
            String cardNumber = InputValidator.getStringInput(scanner, "Enter card number: ");
            String cardHolder = InputValidator.getStringInput(scanner, "Enter cardholder name: ");
            String expiry = InputValidator.getStringInput(scanner, "Enter expiry date (MM/YY): ");
            payment = new CreditCardPayment(total, cardNumber, cardHolder, expiry);
        } else {
            String email = InputValidator.getEmailInput(scanner, "Enter PayPal email: ");
            payment = new PayPalPayment(total, email);
        }

        // Process payment - may throw InvalidPaymentException
        if (payment.processPayment()) {
            // Create order
            String orderId = "ORD" + System.currentTimeMillis();
            Order order = new Order(orderId, cart.getProducts(), total, payment);
            orderHistory.addOrder(order);

            System.out.println(order);
            cart.clearCart();
        }
    }

    private static void viewOrderHistory() {
        orderHistory.displayOrderHistory();
    }

    private static void leaveProductReview() {
        if (catalog.isEmpty()) {
            System.out.println("❌ No products available.");
            return;
        }

        browseProducts();
        int choice = InputValidator.getIntInput(scanner, "\nSelect product to review: ", 1, catalog.size());
        Product product = catalog.get(choice - 1);

        int rating = InputValidator.getIntInput(scanner, "Enter rating (1-5): ", 1, 5);
        String comment = InputValidator.getStringInput(scanner, "Enter your review: ");

        ProductReview review = new ProductReview(currentUser.getUsername(), rating, comment);
        product.addReview(review);

        System.out.println("✅ Review added successfully!");
        System.out.printf("New average rating for %s: %.1f⭐%n", 
                product.getName(), product.getAverageRating());
    }

    /**
     * Search algorithms demonstration.
     * ✅ Requirement: Searching algorithm
     */
    private static void searchProductsDemo() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("🔍 SEARCH ALGORITHMS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search (requires sorted list)");
        System.out.println("3. Recursive Binary Search");

        int choice = InputValidator.getIntInput(scanner, "\nSelect algorithm: ", 1, 3);
        String searchName = InputValidator.getStringInput(scanner, "Enter product name to search: ");

        Product result = null;
        long startTime = System.nanoTime();

        switch (choice) {
            case 1:
                result = SearchAlgorithms.linearSearch(catalog, searchName);
                break;
            case 2:
                List<Product> sorted = SortingAlgorithms.bubbleSort(catalog);
                result = SearchAlgorithms.binarySearch(sorted, searchName);
                break;
            case 3:
                List<Product> sortedRecursive = SortingAlgorithms.bubbleSort(catalog);
                result = SearchAlgorithms.recursiveBinarySearch(sortedRecursive, searchName);
                break;
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        if (result != null) {
            System.out.println("\n✅ Product found!");
            result.displayDetails();
        } else {
            System.out.println("\n❌ Product not found.");
        }

        System.out.printf("\n📊 Comparisons: %d | Time: %.3f ms%n", 
                SearchAlgorithms.getComparisonCount(), duration);
    }

    /**
     * Sorting algorithms demonstration.
     * ✅ Requirement: Sorting algorithm
     */
    private static void sortProductsDemo() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("📊 SORTING ALGORITHMS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Bubble Sort (by name)");
        System.out.println("2. Selection Sort (by price)");
        System.out.println("3. Insertion Sort (by name)");

        int choice = InputValidator.getIntInput(scanner, "\nSelect algorithm: ", 1, 3);

        List<Product> sorted;
        long startTime = System.nanoTime();

        switch (choice) {
            case 1:
                sorted = SortingAlgorithms.bubbleSort(catalog);
                System.out.println("\n✅ Sorted by name (Bubble Sort):");
                break;
            case 2:
                sorted = SortingAlgorithms.selectionSort(catalog);
                System.out.println("\n✅ Sorted by price (Selection Sort):");
                break;
            case 3:
                sorted = SortingAlgorithms.insertionSort(catalog);
                System.out.println("\n✅ Sorted by name (Insertion Sort):");
                break;
            default:
                return;
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        for (int i = 0; i < sorted.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, sorted.get(i));
        }

        System.out.printf("\n📊 Comparisons: %d | Swaps: %d | Time: %.3f ms%n", 
                SortingAlgorithms.getComparisonCount(), 
                SortingAlgorithms.getSwapCount(), 
                duration);
    }

    /**
     * Recursive methods demonstration.
     * ✅ Requirement: Recursive method
     */
    private static void recursiveDemo() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("🔢 RECURSIVE METHODS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Factorial");
        System.out.println("2. Cart Total (Recursive)");
        System.out.println("3. Count Products (Recursive)");
        System.out.println("4. Max Price (Recursive)");
        System.out.println("5. Fibonacci");
        System.out.println("6. Sum to N");
        System.out.println("7. Power Calculation");

        int choice = InputValidator.getIntInput(scanner, "\nSelect demo: ", 1, 7);

        switch (choice) {
            case 1:
                int n = InputValidator.getIntInput(scanner, "Enter number for factorial: ", 0, 20);
                long fact = RecursiveUtils.factorial(n);
                System.out.printf("✅ Factorial of %d = %d%n", n, fact);
                break;

            case 2:
                if (cart.isEmpty()) {
                    System.out.println("❌ Cart is empty.");
                } else {
                    double total = RecursiveUtils.calculateTotalRecursive(cart.getProducts(), 0);
                    System.out.printf("✅ Cart total (recursive): $%.2f%n", total);
                }
                break;

            case 3:
                int count = RecursiveUtils.countProductsRecursive(catalog, 0);
                System.out.printf("✅ Product count (recursive): %d%n", count);
                break;

            case 4:
                if (catalog.isEmpty()) {
                    System.out.println("❌ No products in catalog.");
                } else {
                    double maxPrice = RecursiveUtils.findMaxPriceRecursive(catalog, 0, 0.0);
                    System.out.printf("✅ Maximum price (recursive): $%.2f%n", maxPrice);
                }
                break;

            case 5:
                int fibN = InputValidator.getIntInput(scanner, "Enter position for Fibonacci: ", 0, 40);
                int fib = RecursiveUtils.fibonacci(fibN);
                System.out.printf("✅ Fibonacci(%d) = %d%n", fibN, fib);
                break;

            case 6:
                int sumN = InputValidator.getIntInput(scanner, "Enter N for sum 1 to N: ", 1, 1000);
                int sum = RecursiveUtils.sumToN(sumN);
                System.out.printf("✅ Sum from 1 to %d = %d%n", sumN, sum);
                break;

            case 7:
                double base = InputValidator.getDoubleInput(scanner, "Enter base: ", 0.0);
                int exp = InputValidator.getIntInput(scanner, "Enter exponent: ", -10, 10);
                double result = RecursiveUtils.power(base, exp);
                System.out.printf("✅ %.2f ^ %d = %.6f%n", base, exp, result);
                break;
        }
    }

    /**
     * Save all data to files.
     * ✅ Requirement: File persistence
     */
    private static void saveAllData() {
        System.out.println("\n💾 Saving data...");
        
        boolean productsOk = DataPersistence.saveProducts(catalog);
        boolean ordersOk = DataPersistence.saveOrders(orderHistory.getOrders());
        boolean userOk = DataPersistence.saveUser(currentUser);

        if (productsOk && ordersOk && userOk) {
            System.out.println("✅ All data saved successfully!");
        } else {
            System.out.println("⚠️ Some data could not be saved.");
        }
    }

    /**
     * Load saved data from files.
     * ✅ Requirement: File persistence
     */
    private static void loadSavedData() {
        if (!DataPersistence.hasSavedData()) {
            System.out.println("ℹ️ No saved data found.");
            return;
        }

        System.out.println("\n📂 Loading saved data...");

        User loadedUser = DataPersistence.loadUser();
        if (loadedUser != null) {
            currentUser = loadedUser;
            System.out.println("✅ User loaded: " + currentUser.getUsername());
        }

        List<Product> loadedProducts = DataPersistence.loadProducts();
        if (!loadedProducts.isEmpty()) {
            catalog = loadedProducts;
            System.out.println("✅ Loaded " + catalog.size() + " products.");
        }

        List<Order> loadedOrders = DataPersistence.loadOrders();
        if (!loadedOrders.isEmpty()) {
            orderHistory = new OrderHistory();
            for (Order order : loadedOrders) {
                orderHistory.addOrder(order);
            }
            System.out.println("✅ Loaded " + loadedOrders.size() + " orders.");
        }

        System.out.println("✅ All data loaded successfully!");
    }

    private static void manageUserInfo() {
        if (currentUser == null) {
            System.out.println("❌ No user logged in.");
            return;
        }

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("👤 USER INFORMATION");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Email:    " + currentUser.getEmail());
        System.out.println("Address:  " + (currentUser.getAddress().isEmpty() ? "Not set" : currentUser.getAddress()));
        System.out.println("═══════════════════════════════════════");

        boolean update = InputValidator.getConfirmation(scanner, "\nUpdate address?");
        if (update) {
            String address = InputValidator.getStringInput(scanner, "Enter new address: ");
            currentUser.setAddress(address);
            System.out.println("✅ Address updated!");
        }
    }
}
