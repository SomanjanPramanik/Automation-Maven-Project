package com.creatio.crm.language.basics;

public class PatternBharathAssignment {
/*
 * Print the numbers in diamond-shaped pyramid of numbers.
Pattern should be as below.

    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
 1 2 3 4
  1 2 3
   1 2
    1
 */
public static void main(String[] args) {
	int n = 5;
    int totalCols = 2 * n - 1; // Total columns for a centered diamond 

    // 1. TOP HALF (Rows 0 to 4) [cite: 75, 76]
    for (int i = 0; i < n; i++) {
        int num = 1; // Reset counter for every row 
        for (int j = 0; j < totalCols; j++) {
            // Condition: j >= n-1-i AND j <= n-1+i [cite: 76]
            if (j >= n - 1 - i && j <= n - 1 + i) {
                // Check if we print a number or a space for the "spaced" look
                // Based on the grid, numbers appear when (j + i) and (n-1) have same parity
                if ((j + i + n - 1) % 2 == 0) {
                    System.out.print(num++);
                } else {
                    System.out.print(" ");
                }
            } else {
                System.out.print(" "); // Print space outside the diamond bounds [cite: 8, 50]
            }
        }
        System.out.println(); // New line after each row [cite: 10, 36]
    }
    for (int i = 0; i < n-1; i++) {
        int num = 1;
        // Total columns must be enough to house the widest part (n + (n-1))
        for (int j = 0; j < totalCols; j++) { 
            // Corrected Condition for centering:
            // Start moves right (+1) each row, End moves left (-1)
            if (j >= i + 1 && j <= (2*n-2)-i) {
                
                // To get the "1 2 3" spaced look from your image:
                // We only print numbers on every OTHER column 
                if ((i + j) % 2 != 0) { 
                    System.out.print(num++);
                } else {
                    System.out.print(" ");
                }
                
            } else {
                // Print leading spaces so it doesn't lean left [cite: 8]
                System.out.print(" ");
            }
        }
        System.out.println(); // New line after each row [cite: 10]
    }
  }
}