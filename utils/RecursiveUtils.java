package com.onlinestore.utils;

import com.onlinestore.model.Product;
import java.util.List;

/**
 * Utility class with recursive methods for various calculations.
 * ✅ Requirement: Recursive method
 */
public class RecursiveUtils {

    /**
     * Calculate factorial recursively.
     * ✅ Requirement: Recursive method
     */
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Calculate total cart value recursively.
     * ✅ Requirement: Recursive method
     */
    public static double calculateTotalRecursive(List<Product> products, int index) {
        if (index >= products.size()) {
            return 0.0;
        }
        return products.get(index).getPrice() + calculateTotalRecursive(products, index + 1);
    }

    /**
     * Count products recursively.
     * ✅ Requirement: Recursive method
     */
    public static int countProductsRecursive(List<Product> products, int index) {
        if (index >= products.size()) {
            return 0;
        }
        return 1 + countProductsRecursive(products, index + 1);
    }

    /**
     * Find max price recursively.
     * ✅ Requirement: Recursive method
     */
    public static double findMaxPriceRecursive(List<Product> products, int index, double maxSoFar) {
        if (index >= products.size()) {
            return maxSoFar;
        }
        double currentPrice = products.get(index).getPrice();
        double newMax = Math.max(maxSoFar, currentPrice);
        return findMaxPriceRecursive(products, index + 1, newMax);
    }

    /**
     * Sum of integers from 1 to n (recursive).
     * ✅ Requirement: Recursive method
     */
    public static int sumToN(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumToN(n - 1);
    }

    /**
     * Fibonacci sequence (recursive).
     * ✅ Requirement: Recursive method
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Power calculation (recursive).
     * ✅ Requirement: Recursive method
     */
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        return base * power(base, exponent - 1);
    }
}
