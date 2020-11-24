package com.selenium.practice;

public class SecondOccuerenceCharacter {
	public char SecondOccureChar(String s) {
		int noofchar = 256;
		int[] ctr = new int[noofchar];
		for (int i = 0; i < s.length(); i++)
			(ctr[s.charAt(i)]) ++;
		int first = 0, second = 0;
		for (int i = 0; i < noofchar; i++) {
			if (ctr[i] > ctr[first]) {
				second = first;
				first = i;
			} else if (ctr[i] > ctr[second] && ctr[i] != ctr[first])
				second = i;
		}
		return (char)second;
	}
	public static void main(String[] args) {
		SecondOccuerenceCharacter secondchar = new SecondOccuerenceCharacter();
		String s = "Welcome to testleaf";
		char s1 = secondchar.SecondOccureChar(s);
		System.out.println(s1);
	}
}