package com.selenium.practice;

import java.io.*;
import java.util.*;

public class Practice {
	public static void main(String[] args) {
		Map<Character,Integer> max = new LinkedHashMap<Character, Integer>();
		//String s = "Amazon is a great company as it haas AtoooZzz";
		String s = "Successc";
		char ch1[] = s.toLowerCase().toCharArray();
		int count = 1;
		for(int i=0;i<ch1.length;i++) {
			for(int j=i+1;j<ch1.length;) {
				if(ch1[i]==ch1[j]) {
					count++;
					max.put(ch1[i],count);
				}else {
					count = 1;
				}
				break;
			}
		}
		System.out.println(max);
	}
}