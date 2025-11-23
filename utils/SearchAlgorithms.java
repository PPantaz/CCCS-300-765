package com.onlinestore.utils;

import com.onlinestore.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Search algorithms for products.
 * Requirement: Searching algorithm (linear/binary search)
 * Requirement: Recursive method
 */
public class SearchAlgorithms {
    
    private static int comparisonCount = 0;

    /**
     * Linear search for a product by name (case-insensitive).
     * Requirement: Searching algorithm
     */
    public static Product linearSearch(List<Product> products, String name) {
        comparisonCount = 0;
        for (Product product : products) {
            comparisonCount++;
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary search for a product by name (requires sorted list).
     * Requirement: Searching algorithm
     */
    public static Product binarySearch(List<Product> products, String name) {
        comparisonCount = 0;
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            comparisonCount++;
            int mid = left + (right - left) / 2;
            int comparison = products.get(mid).getName().compareToIgnoreCase(name);

            if (comparison == 0) {
                return products.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * Recursive binary search implementation.
     * Requirement: Recursive method
     */
    public static Product recursiveBinarySearch(List<Product> products, String name) {
        comparisonCount = 0;
        return recursiveBinarySearchHelper(products, name, 0, products.size() - 1);
    }

    private static Product recursiveBinarySearchHelper(List<Product> products, String name, 
                                                       int left, int right) {
        if (left > right) {
            return null;
        }

        comparisonCount++;
        int mid = left + (right - left) / 2;
        int comparison = products.get(mid).getName().compareToIgnoreCase(name);

        if (comparison == 0) {
            return products.get(mid);
        } else if (comparison < 0) {
            return recursiveBinarySearchHelper(products, name, mid + 1, right);
        } else {
            return recursiveBinarySearchHelper(products, name, left, mid - 1);
        }
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }
}
