package com.selenium.practice;

public class Number_of_Digit_One {
	public int numberofDigit(int n) {
		int count = 0;
		for(int i=1;i<=100;i++) {
			String s1 = String.valueOf(i);
			if(s1.contains(String.valueOf(n))) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Number_of_Digit_One digit = new Number_of_Digit_One();
		int n = 1;
		System.out.println(digit.numberofDigit(n));
	}
}