package com.creatio.crm.language.basics;

public class BestDayToBuySell {

	public static void main(String[] args) {
		int[] matrix = { 1, 6, 6, 6, 90, 3, 9, 6, 1, 5 };
		System.out.println(BestDayToBuySell.bestDayToBuySell(matrix));
	}

	private static int bestDayToBuySell(int[] arr) {

		int maxProfit = 0;

		if (arr == null || arr.length < 2) {
			return maxProfit;
		}

		int bp = arr[0];

		int bestDayToBuy = 1;
		int tempBuyDay = 1;
		int bestDaytoSell = 1;

		for (int i = 1; i < arr.length; i++) {

			int todaySP = arr[i];
			int currentProfit = todaySP - bp;
			if (currentProfit > maxProfit) {
				bestDayToBuy = tempBuyDay;
				bestDaytoSell = i + 1;
				maxProfit = currentProfit;
			} else {
				bp = todaySP;
				tempBuyDay = i + 1;
			}

		}

		if (maxProfit > 0) {
			System.out.println("best day to buy :" + bestDayToBuy + " best day to sell : " + bestDaytoSell);
		}
		return maxProfit;
	}

}
