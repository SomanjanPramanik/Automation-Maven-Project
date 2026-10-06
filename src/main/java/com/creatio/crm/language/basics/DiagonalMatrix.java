package com.creatio.crm.language.basics;

import java.util.Arrays;

public class DiagonalMatrix {
	
	public static void main(String... args) {
		int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
		DiagonalMatrix.diagonalSum(arr);
	}
	public static void diagonalSum(int[][] arr) {
		
		System.out.println("The matrix :");
		for (int[] inArr : arr) {
			System.out.print(Arrays.toString(inArr));
			System.out.println();
		}
		System.out.println();
		
		
		//i=j == lenght -1 and i==j
		//i+j = length-1
		//so j = length-1-i
		for(int i = 0 ; i < arr.length ; i++) {
			
			System.out.println("Primary Diagonal Matrix : "+arr[i][i]);
			
			System.out.println("Secondary Diagonal Matrix : "+arr[i][arr.length-1-i]);
			
		}
		
		//now to avoid middle term we do : if(i != lenght-1-i)
		
	}

}
