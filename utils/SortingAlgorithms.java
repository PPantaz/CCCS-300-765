package com.onlinestore.utils;

import com.onlinestore.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Sorting algorithms for products.
 * Requirement: Sorting algorithm (bubble/insertion/selection sort)
 */
public class SortingAlgorithms {
    
    private static int comparisonCount = 0;
    private static int swapCount = 0;

    /**
     * Bubble sort - sorts products by name (ascending).
     * Requirement: Sorting algorithm
     */
    public static List<Product> bubbleSort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        comparisonCount = 0;
        swapCount = 0;
        int n = sorted.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisonCount++;
                if (sorted.get(j).getName().compareToIgnoreCase(sorted.get(j + 1).getName()) > 0) {
                    // Swap
                    Product temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: exit if no swaps
        }
        return sorted;
    }

    /**
     * Selection sort - sorts products by price (ascending).
     * Requirement: Sorting algorithm
     */
    public static List<Product> selectionSort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        comparisonCount = 0;
        swapCount = 0;
        int n = sorted.size();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++;
                if (sorted.get(j).getPrice() < sorted.get(minIdx).getPrice()) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                Product temp = sorted.get(i);
                sorted.set(i, sorted.get(minIdx));
                sorted.set(minIdx, temp);
                swapCount++;
            }
        }
        return sorted;
    }

    /**
     * Insertion sort - sorts products by name (ascending).
     * Requirement: Sorting algorithm
     */
    public static List<Product> insertionSort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        comparisonCount = 0;
        swapCount = 0;
        int n = sorted.size();

        for (int i = 1; i < n; i++) {
            Product key = sorted.get(i);
            int j = i - 1;

            while (j >= 0) {
                comparisonCount++;
                if (sorted.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                    sorted.set(j + 1, sorted.get(j));
                    swapCount++;
                    j--;
                } else {
                    break;
                }
            }
            sorted.set(j + 1, key);
        }
        return sorted;
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }

    public static int getSwapCount() {
        return swapCount;
    }
}
