package com.selenium.practice;

import java.util.*;

public class CharacterCount {
	public static void char_split(String s1) {
		List<String> list = new ArrayList<String>();
		String[] s2 = s1.split("(?<=\\G.{2})");
		for(int i=0;i<s2.length;i++) {
			list.add(s2[i]);
		}
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			int count = 1;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))) {
					count++;
					break;
				}
			}
			System.out.println(list.get(i) + " = " + count);
		}
	}
	public static void main(String[] args) {
		String s1 = "Aabbccaabbddaacc";
		char_split(s1);
	}
}