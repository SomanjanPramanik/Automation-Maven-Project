package com.creatio.crm.language.basics;

import java.util.Arrays;

public class Binarysearch {

	public static void main(String[] args) {

		int[] arr = { 12, 45, 52, 3, 4, 5, 6, 9 };
		//System.out.println(Arrays.toString(Binarysearch.selectionSort(arr)));
		// System.out.println(Binarysearch.search(arr, 12));
		//Binarysearch.insertionSort(arr);
		//System.out.println();
		//Binarysearch.selection_Sort(arr);
		
		Binarysearch.rotateSortArray(arr, 9);

	}

	public static boolean search(int[] arr, int key) {

		if (arr.length < 1 || arr == null) {

			return false;

		}

		// sorting
		// insertion : 2 list => sl ul

		for (int i = 1; i < arr.length; i++) {

			int current = arr[i];
			int prev = i - 1;

			while (prev >= 0 && arr[prev] > current) {
				arr[prev + 1] = arr[prev];
				prev--;
			}
			// prev eventually becomes -1
			arr[prev + 1] = current;
			System.out.println(Arrays.toString(arr));
		}

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (key == arr[mid]) {

				return true;

			} else if (key < arr[mid]) {

				end = mid - 1;

			} else {

				start = mid + 1;

			}

		}

		return false;
	}

	// selection sort : smallest nibo tarpor seta k prothome bosiye dibo
	public static int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			int smallest = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < arr[smallest]) {

					smallest = j;
				}

			}

			// swap b/w smallest and arr[i]
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;

			System.out.println(Arrays.toString(arr));

		}

		return arr;
	}

	// insertion sort : sl ul
	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int prev = i - 1;
			
			while(prev>=0 && arr[prev]> current) {
				
				arr[prev+1] = arr[prev];
				prev--;
				
			}
			
			arr[prev+1] = current;
			
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//seection sort:
	public static void selection_Sort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			
			int minPos = i ;
			
			for(int j = i+1 ; j < arr.length ; j++) {
				
				if(arr[j]<arr[minPos]) {
					
					minPos = j;
					
				}
				
			}
			
			//swap
			int temp = arr[minPos];
			arr[minPos] = arr[i];
			arr[i] = temp;
			
			
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//2 pointer - sum
	public static void rotateSortArray(int[] arr , int key) {
		
		int bp = -1;
		for(int i = 0; i < arr.length -1 ; i++) {
			
			if(arr[i]>arr[i+1]) {
				
				bp = i;
				
			}
			
		}
		
		int start = (bp + 1) % arr.length; 
	    int end = (bp != -1) ? bp : arr.length - 1;
		
		while(start != end) {
			int sum = arr[start]+arr[end];
			if(sum == key) {
				
				System.out.println(start + " " + end);
				
				if ((start + 1) % arr.length == end) {
	                break;
	            }
				
				start = (start+1)%arr.length;
				
				end = (end -1 + arr.length)%arr.length;
				
			}
			else if(sum < key) {
				
				start = (start+1)%arr.length;
				
			}
			else {
				
				end = (end -1 + arr.length)%arr.length;
				
			}
			
			System.out.println("now start : "+ start+" "+"end : "+ end);
			
		}
		
	}
	
}
