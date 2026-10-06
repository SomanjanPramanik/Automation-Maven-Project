package practice.striever.recurssion;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanPGE {

	public static int[] prevConsecutiveSamePriceOrLess(int[] stock) {

		int n = stock.length;
		int[] span = new int[n];
		Stack<Integer> PGE = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!PGE.isEmpty() && stock[PGE.peek()] <= stock[i]) {
				PGE.pop();
			}

			if (PGE.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - PGE.peek();
			}

			PGE.push(i);

		}

		return span;
	}

	public static void main(String[] args) {

		int[] stock = { 100, 80, 60, 70, 60, 85, 100 };
		System.out.println(Arrays.toString(prevConsecutiveSamePriceOrLess(stock)));
	}

}
