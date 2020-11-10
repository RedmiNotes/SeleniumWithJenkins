package com.logical.programs;

public class Multiply_Strings {
	public String multiply(String num1, String num2) {
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int n3 = n1*n2;
		//String s1 = String.valueOf(n3);
		String s2 = Integer.toString(n3);
		return s2;
	}
	public static void main(String[] args) {
		Multiply_Strings ms = new Multiply_Strings();
		String num1 = "123";
		String num2 = "456";
		System.out.println(ms.multiply(num1, num2));
	}
}