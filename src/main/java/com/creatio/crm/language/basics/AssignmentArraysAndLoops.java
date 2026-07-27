package com.creatio.crm.language.basics;

import java.util.Arrays;

public class AssignmentArraysAndLoops {

	public static void main(String[] args) {
		/*
		 * Given values are 12,34,11,36,87,98,93. Store the values in Array and Print
		 * second and third largest number from the above values without using
		 * collections and default sort methods
		 */
		int[] values = { 12, 34, 11, 36, 87, 98, 93 };
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = 0; j < values.length - 1; j++) {
				int temp = 0;
				if (values[j] > values[j + 1]) {
					temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}

			}

		}
		System.out.println(Arrays.toString(values)); // ✅ prints actual values
		System.out.println("Second largest: " + values[values.length - 2]);
		System.out.println("Third largest: " + values[values.length - 3]);

		/*
		 * Write a program that:
		 * 
		 * 1. Store these numbers in an array: `5, 2, 8, 1, 9, 3, 7, 4, 6` 
		 * 2. Sort them in **descending order** (largest to smallest) using bubble sort — 
		 * no collections, no sort methods 
		 * 3. Print the **sorted array** 
		 * 4. Print the **3rd
		 * and 5th** smallest numbers
		 * 
		 * 💪
		 */
		int[] arr = {5, 2, 8, 1, 9, 3, 7, 4, 6};
		for(int i = 0; i < arr.length-1 ; i++) {
			for(int j = 0; j < arr.length-1 ; j++) {
				if(arr[j] < arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("3rd smallest numbers: " + arr[arr.length-3]);
		System.out.println("5th smallest numbers: " + arr[arr.length-5]);
	}
}
