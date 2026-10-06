package practice.striever.recurssion;

import java.util.*;

public class CircularNGEPGE {
	// same nge pge logic sudhu array ta 2 baar dhurte hbe mane 0 to n-1 r bodole
	// 2*n-1 r index janis too i = i%n

	public static int[] circularPGE(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[0];
		}
		int n = arr.length;
		int[] pgeArr = new int[n];
		Stack<Integer> stack = new Stack<>();
		// PGE mane
		for (int i = 0; i <= 2 * n - 1; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
				stack.pop();
			}
			if (i >= n) {
				if (stack.isEmpty()) {
					pgeArr[i % n] = -1;
				} else {
					pgeArr[i % n] = stack.peek();
				}
			}
			stack.push(arr[i % n]);
		}

		return pgeArr;
	}

	public static int[] circularNGE(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[0];
		}
		int n = arr.length;
		int[] ngeArr = new int[n];
		Stack<Integer> stack = new Stack<>();
		// NGE mane
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
				stack.pop();
			}
			if (i < n) {
				if (stack.isEmpty()) {
					ngeArr[i % n] = -1;
				} else {
					ngeArr[i % n] = stack.peek();
				}
			}
			stack.push(arr[i % n]);
		}
		return ngeArr;
	}

	public static void main(String[] args) {
		int[][] testCases = { { 1, 2, 1 }, // 1. Standard Circular Example
				{ 1, 2, 3, 4, 3 }, // 2. Wrap-around needed for elements
				{ 5, 4, 3, 2, 1 }, // 3. Decreasing Array
				{ 1, 1, 1, 1 }, // 4. All Elements Same (No greater exists)
				{ 10 }, // 5. Single Element
				{ 3, 8, 4, 1, 2 } // 6. Mixed elements
		};

		System.out.println("========== CIRCULAR NGE TEST ==========");
		for (int i = 0; i < testCases.length; i++) {
			int[] input = testCases[i];
			int[] res = circularNGE(input);
			System.out.println("Test " + (i + 1) + " Input: " + Arrays.toString(input));
			System.out.println("NGE Output : " + Arrays.toString(res));
			System.out.println();
		}

		System.out.println("========== CIRCULAR PGE TEST ==========");
		for (int i = 0; i < testCases.length; i++) {
			int[] input = testCases[i];
			int[] res = circularPGE(input);
			System.out.println("Test " + (i + 1) + " Input: " + Arrays.toString(input));
			System.out.println("PGE Output : " + Arrays.toString(res));
			System.out.println();
		}
	}

}
