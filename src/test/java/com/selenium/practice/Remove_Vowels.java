package com.selenium.practice;

import java.util.*;

public class Remove_Vowels {

	public static String removeVowels_01(String str) {
		String s1 = "";
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u') {
				continue;
			}else {
				s1 += ch[i];
			}
		}
		return s1;
	}

	public static String removeVowels_02(String str) {
		return str.replaceAll("[aeiou]", "");
	}

	public static String removeVowels_03(String str) {
		return str.replaceAll("([aeiou\\W]+)", "");
	}

	public static String removeVowels_04(String str) {
		String s1 = "aeiou";
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : ch) {
			if(s1.indexOf(c)<0) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String removeVowels_05(String str) {
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<Character>();
		set.add('a');	   
		set.add('e');	    
		set.add('i');	    
		set.add('o');    
		set.add('u');
		for (int i = 0; i < ch.length; i++) {
			if (!set.contains(ch[i])) {
				sb.append(ch[i]);
			}
		}
		return sb.toString();
	}

	public static String removeVowels_06(String str) {
		List<Character> li = new ArrayList<Character>();
		li.add('a');
		li.add('e');
		li.add('i');
		li.add('o');
		li.add('u');
		StringBuffer sb = new StringBuffer(str);
		for(int i = 0; i < sb.length(); i++) {
			if(li.contains(sb.charAt(i))) {
				sb.replace(i, i + 1, "");
				i--;
			}
		}
		return sb.toString();
	}

	public static String removeVowels_07(String str) {
		String s1 = "";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
				continue;
			} else {
				s1 += str.charAt(i);
			}
		}
		return s1;
	}

	public static String removeVowels_08(String str) {
		String s1 = "";
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			switch (ch[i]) {
			case 'a':
				continue;
			case 'e':
				continue;
			case 'i':
				continue;
			case 'o':
				continue;
			case 'u':
				continue;
			default:
				s1 += ch[i];
				break;
			}
		}
		return s1;
	}

	public static void main(String[] args) {
		String s2 = "youwillwinthis";
		//String s2 = "aeiou";
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_01(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_02(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_03(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_04(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_05(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_06(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_07(s2));
		System.out.println("------------------------------------------------");
		System.out.println("Before Remove Vowels : " + s2);
		System.out.println(" After Remove Vowels : " + removeVowels_08(s2));
		System.out.println("------------------------------------------------");
	}
}