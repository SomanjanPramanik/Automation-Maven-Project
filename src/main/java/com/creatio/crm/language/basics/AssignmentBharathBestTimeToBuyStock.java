package com.creatio.crm.language.basics;
import java.util.ArrayList;
import java.util.List;

public class AssignmentBharathBestTimeToBuyStock {
/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
   a different day in the future to sell that stock.
   Return the maximum profit you can achieve from this transaction. If you cannot achieve
   any profit, return 0.
   Example 1:
   Input: prices = [7,1,5,3,6,4]
   Output: 5
   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 */
	public static void main(String[] args) {
		int[] prices = {7,6,4};
		System.out.println("Max profit : $"+bestTimeToBuyStock(prices));

	}
	public static int bestTimeToBuyStock(int[] prices) {
		
		int maxProfit = 0;
		int minPriceDay = 0;
		int maxPriceDay = 0;
		for (int i = 0 ; i < prices.length-1 ; i++) {
			for (int j = i+1 ; j < prices.length ; j++) {
				int currentProfit = prices[j]-prices[i];
				if(currentProfit>maxProfit) {
					minPriceDay = i+1;
					maxPriceDay = j+1;
					maxProfit = currentProfit;
					
				}
			}
		}
		if(maxProfit > 0) {
		System.out.println("The best day to buy : "+minPriceDay+" ( price : $"+prices[minPriceDay-1]+")");
		System.out.println("and to sell is : "+maxPriceDay+" ( price : $"+prices[maxPriceDay-1]+")");
		return maxProfit;
		}
		else {
			System.out.println("Don't sell otherwise you'd lose your money");
			return 0;
		}
	}

}
