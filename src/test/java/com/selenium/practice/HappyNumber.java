package com.selenium.practice;

public class HappyNumber {
	public int isHappy(int n) {
		int sum = n;
		while(n>1) {
			sum = 0;
			while(0<n) {
				int r = n%10;
				sum = sum + (r*r);
				n/=10;
			}
			n = sum;
		}
		if(sum==1) {
			System.out.println("Happy Number");
		}else {
			System.out.println("Not Happy Number");
		}
		return sum;
	}
	public static void main(String[] args) {
		HappyNumber happynumber = new HappyNumber();
		int n = 2;
		happynumber.isHappy(n);
	}
}