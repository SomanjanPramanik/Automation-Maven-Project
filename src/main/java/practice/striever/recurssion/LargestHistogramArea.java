package practice.striever.recurssion;

import java.util.*;

public class LargestHistogramArea {

	public static int LargestArea(int[] heights) {
		int maxArea = 0;

		Stack<Integer> stack = new Stack<>();

		int n = heights.length;

		int[] nse = new int[n];

		int[] pse = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			pse[i] = stack.isEmpty() ? -1 : stack.peek();

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			stack.pop();
		}

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			nse[i] = stack.isEmpty() ? n : stack.peek();

			stack.push(i);
		}

		for (int i = 0; i < n; i++) {
			int currAera = (nse[i] - pse[i] - 1) * heights[i];
			maxArea = Math.max(maxArea, currAera);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println("Max Area: " + LargestArea(heights)); // Output আসবে 10
	}
}
