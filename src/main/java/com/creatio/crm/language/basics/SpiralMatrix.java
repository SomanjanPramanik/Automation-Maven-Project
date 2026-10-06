package com.creatio.crm.language.basics;

import java.util.Arrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1 }, { 6 }, { 9 }, { 12 } };
		SpiralMatrix.printSpiralmatrix(matrix);

	}

	private static void printSpiralmatrix(int[][] arr) {
		System.out.println("The matrix :");
		for (int[] inArr : arr) {
			System.out.print(Arrays.toString(inArr));
			System.out.println();
		}
		System.out.println();

		System.out.println("The spiral path of matrix :");

		// get all boundaries
		int startRow = 0;
		int endRow = arr.length - 1;
		int startCol = 0;
		int endCol = arr[0].length - 1;

		// get a loop until all row and end finishes
		while (startRow <= endRow && startCol <= endCol) {

			// top[row fixed = startRow and column variable from startCol to endCol]
			for (int j = startCol; j <= endCol; j++) {
				if (j != 0) {
					System.out.print("->");
				}
				System.out.print(arr[startRow][j]);
			}
			// right
			for (int i = startRow + 1; i <= endRow; i++) {
				System.out.print("->" + arr[i][endCol]);
			}
			// bottom
			for (int j = endCol - 1; j >= startCol; j--) {
				if (startRow == endRow) {
					break;
				}
				System.out.print("->" + arr[endRow][j]);
			}
			// left
			for (int i = endRow - 1; i >= startRow + 1; i--) {
				if (startCol == endCol) {
					break;
				}
				System.out.print("->" + arr[i][startCol]);
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
	}

}
