package com.selenium.practice;

import java.util.*;

public class CharacterCount {
	public static void char_split(String s1) {
		List<String> list = new ArrayList<String>();
		char[] ch = s1.toCharArray();
		for(int i=0;i<ch.length;i++) {
			String s2 = "";
			for(int j=0;j<2;j++) {
				s2 += ch[i];
			}
			list.add(s2);
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		String s1 = "Aabbccaabbddaacc";
		char_split(s1);
	}
}