package com.onlinestore.utils;

import java.util.Scanner;

/**
 * Input validation utility for robust error handling.
 * ✅ Requirement: Input validation and robust error recovery
 */
public class InputValidator {

    /**
     * Get a valid integer input within a range.
     * ✅ Requirement: Input validation
     */
    public static int getIntInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    System.out.println("❌ Input cannot be empty. Please try again.");
                    continue;
                }

                int value = Integer.parseInt(input);
                
                if (value < min || value > max) {
                    System.out.printf("❌ Please enter a number between %d and %d.%n", min, max);
                    continue;
                }
                
                return value;
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Get a valid double input (for prices, amounts).
     * ✅ Requirement: Input validation
     */
    public static double getDoubleInput(Scanner scanner, String prompt, double min) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    System.out.println("❌ Input cannot be empty. Please try again.");
                    continue;
                }

                double value = Double.parseDouble(input);
                
                if (value < min) {
                    System.out.printf("❌ Amount must be at least %.2f.%n", min);
                    continue;
                }
                
                return value;
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Get a non-empty string input.
     * ✅ Requirement: Input validation
     */
    public static String getStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("❌ Input cannot be empty. Please try again.");
                continue;
            }
            
            return input;
        }
    }

    /**
     * Get a yes/no confirmation.
     * ✅ Requirement: Input validation
     */
    public static boolean getConfirmation(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    /**
     * Validate email format.
     * ✅ Requirement: Input validation
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    /**
     * Validate credit card number (simple length check).
     * ✅ Requirement: Input validation
     */
    public static boolean isValidCreditCard(String cardNumber) {
        String cleaned = cardNumber.replaceAll("\\s+", "");
        return cleaned.matches("\\d{13,19}");
    }

    /**
     * Get valid email input.
     * ✅ Requirement: Input validation
     */
    public static String getEmailInput(Scanner scanner, String prompt) {
        while (true) {
            String email = getStringInput(scanner, prompt);
            
            if (isValidEmail(email)) {
                return email;
            } else {
                System.out.println("❌ Invalid email format. Please try again.");
            }
        }
    }
}
