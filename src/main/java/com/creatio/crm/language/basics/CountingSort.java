package com.creatio.crm.language.basics;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {

		int[] arr = { 2, 4, 5, 6, 1, 2, 1, 3, 4 };
        CountingSort.countSort(arr);
	}

	public static void countSort(int[] arr) {


		// first get limit

		int largest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			largest = Math.max(largest, arr[i]);

		}

		// then create new array and get frequency

		int[] freq = new int[largest + 1];

		for (int i = 0; i < arr.length; i++) {

			freq[arr[i]] = freq[arr[i]] + 1;

			System.out.println(Arrays.toString(freq));

		}
		
		System.out.println();

		// Now sort now sort according to freq so for range now new array size

		int j = 0;
		for (int i = 0; i < freq.length; i++) {

			// decrese until freq(i) == 0

			while (freq[i] > 0) {

				arr[j] = i;
				j++;
				freq[i]--;

				System.out.println(Arrays.toString(freq));
				System.out.println(Arrays.toString(arr));
			}

		}
		
		System.out.println();
		
		System.out.println(Arrays.toString(arr));

	}
}
