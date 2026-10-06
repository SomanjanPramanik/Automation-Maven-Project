package practice.striever.recurssion;

import java.util.*;

public class StackNSEPSE {

	public static int[] NSE(int[] arr) {

		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}

			nseArr[i] = stack.isEmpty() ? -1 : stack.peek();

			stack.push(arr[i]);
		}
		return nseArr;

	}

	public static int[] PSE(int[] arr) {

		int n = arr.length;
		int[] pseArr = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}

			pseArr[i] = stack.isEmpty() ? -1 : stack.peek();

			stack.push(arr[i]);
		}
		return pseArr;

	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };
		System.out.println("Arr: " + Arrays.toString(arr));
		System.out.println("NSE: " + Arrays.toString(NSE(arr))); // [2, 2, -1, 8, -1]
		System.out.println("PSE: " + Arrays.toString(PSE(arr))); // [-1, 4, -1, 2, 2]
	}

}
