package com.selenium.practice;

import java.util.Scanner;

public class Else_IF_Examp {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the Integer : ");
		int N = s1.nextInt();
		if (N % 2 == 1){
			System.out.println("Weird");
		} else if (N % 2 == 0){
			if (N >= 2 && N <= 5) {
				System.out.println("Not Weird");
			} else if (N >= 6 && N <= 20){
				System.out.println("Weird");
			} else if (N > 20){
				System.out.println("Not Weird");
			}
		}
		s1.close();
	}
}
