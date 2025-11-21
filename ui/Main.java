package com.onlinestore.ui;

import com.onlinestore.model.*;
import com.onlinestore.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User registration/login
        System.out.println("=== Welcome to the Online Store ===");
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        User user = new User(username, email);

        System.out.println("\nHello, " + user.getUsername() + "! Let's start shopping.");

        ShoppingCart cart = new ShoppingCart();
        OrderHistory history = new OrderHistory();
// Front Display
        while (true) {
            System.out.println("\n--- ONLINE STORE MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Apply Discount");
            System.out.println("4. Checkout");
            System.out.println("5. View Orders");
            System.out.println("6. Leave Product Review");
            System.out.println("7. View Product Reviews");
            System.out.println("8. View My Info");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product type (1. Electronics 2. Grocery 3. Clothing): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    Product p;
                    switch (type) {
                        case 1 -> p = new Electronics(name, price);
                        case 2 -> p = new Grocery(name, price);
                        case 3 -> p = new Clothing(name, price);
                        default -> {
                            System.out.println("Invalid type. Adding as generic product.");
                            p = new Clothing(name, price);
                        
                        }
                    }
                    cart.addProduct(p);
                    System.out.println(name + " added to cart.");
                    break;

                case 2:
                    cart.displayCart();
                    break;

                case 3:
                    System.out.print("Enter discount percentage: ");
                    double discount = sc.nextDouble();
                    sc.nextLine();
                    cart.applyDiscountToAll(discount);
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty.");
                        break;
                    }
                    System.out.println("Choose Payment: 1. Credit Card  2. PayPal");
                    int payChoice = sc.nextInt();
                    sc.nextLine();
                    Payment payment;

                    if (payChoice == 1) {
                        System.out.print("Enter card number: ");
                        String cardNumber = sc.nextLine();
                        payment = new CreditCardPayment(cart.calculateTotal(), cardNumber);
                    } else {
                        System.out.print("Enter PayPal email: ");
                        String paypalEmail = sc.nextLine();
                        payment = new PayPalPayment(cart.calculateTotal(), paypalEmail);
                    }

                    Order order = cart.checkout(payment);
                    if (order != null) {
                        history.addOrder(order);
                        System.out.println("Order completed successfully for " + user.getUsername() + "!");
                    }
                    break;

                case 5:
                    history.viewHistory();
                    break;

                case 6:
                    System.out.print("Enter product name to review: ");
                    String prodName = sc.nextLine();
                    Product productToReview = cart.findProductByName(prodName);
                    if (productToReview == null) {
                        productToReview = history.findProductByName(prodName);
                        if (productToReview == null) {
                            System.out.println("Product not found in your cart or order history.");
                            break;
                        }
                    }
                    System.out.print("Enter rating (1–5): ");
                    int rating = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter comment: ");
                    String comment = sc.nextLine();

                    ProductReview review = new ProductReview(rating, comment);
                    productToReview.addReview(review);
                    System.out.println("Thanks for reviewing " + prodName + "!");
                    break;

                case 7:
                    System.out.print("Enter product name to view reviews: ");
                    String reviewName = sc.nextLine();
                    Product product = cart.findProductByName(reviewName);
                    if (product == null) product = history.findProductByName(reviewName);
                    if (product != null) product.displayInfo();
                    else System.out.println("Product not found.");
                    break;

                case 8:
                    System.out.println("\n--- USER INFORMATION ---");
                    System.out.println(user);
                    break;

                case 9:
                    System.out.println("Goodbye, " + user.getUsername() + "!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
