package com.logical.programs;

public class Four {
	public static void main(String[] args) {
		String s1 = "combinatio";
		for(int i=0;i<(s1.length()/2);i++) {
			System.out.println(s1.substring(i,s1.length()-(i+1)));
			System.out.println(s1.substring(i+1,s1.length()-(i+1)));
		}
	}
}