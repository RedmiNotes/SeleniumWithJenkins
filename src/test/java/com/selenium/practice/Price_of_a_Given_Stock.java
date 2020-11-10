package com.selenium.practice;

public class Price_of_a_Given_Stock {
	public static int maxProfit(int prices[]) {
		int maxprofit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxprofit)
					maxprofit = profit;
			}
		}
		return maxprofit;
	}
	public static void main(String[] args) { 
		int price[] = {7,1,5,3,6,4}; 
		maxProfit(price);
		System.out.println(maxProfit(price)); 
	}
}