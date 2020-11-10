package com.logical.programs;

public class Palindrome_Number {
	public boolean isPalindrome(int x) {
		int n = x;
		int sum = 0;
		boolean flag;
		while(x>0) {
			int r = x%10;
			sum = (sum*10) + r;
			x/=10;
		}
		if(n==sum) {
			flag = true;
		}else {
			flag = false;
		}
		return flag;
	}
	public static void main(String[] args) {
		Palindrome_Number pn= new Palindrome_Number();
		int x = -101;
		System.out.println(pn.isPalindrome(x));
	}
}