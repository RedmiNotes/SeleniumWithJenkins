package com.selenium.practice;

import java.util.*;
import java.util.Map.Entry;

public class MaximumOccurenceofConsecutiveCharacter {
	public char maximumchar(String s) {
		Map<Character,Integer> maxcharandcount = new LinkedHashMap<Character, Integer>();
		char ch1[] = s.toCharArray();
		int count = 0;
		char ch = 0;
		for(int i=0;i<ch1.length;i++) {
			for(int j=i+1;j<ch1.length;) {
				if(ch1[i]==ch1[j]) {
					count++;
					maxcharandcount.put(ch1[i],count);
				}else {
					count = 1;
				}
				break;
			}
		}

		System.out.println("The Consecutive Character and count : " + maxcharandcount);

		int maxcount = Collections.max(maxcharandcount.values());
		for(Entry<Character, Integer> maxconchar : maxcharandcount.entrySet()) {
			if(maxconchar.getValue()==maxcount) {
				ch = maxconchar.getKey();
				break;
			}
		}
		return ch;
	}
	public static void main(String[] args) {
		MaximumOccurenceofConsecutiveCharacter consecutive = new MaximumOccurenceofConsecutiveCharacter();
		String s = "Amazon is a great company as it haas AtoooZzz";
		//String s = "Succcccessssssss";
		System.out.println("The Consecutive Character is : " + consecutive.maximumchar(s));
	}
}