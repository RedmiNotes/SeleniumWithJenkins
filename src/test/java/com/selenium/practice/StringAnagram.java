package com.selenium.practice;

public class StringAnagram {
	public boolean String_Anagram(String s, String t) {
		boolean flag;

		if(s.length() != t.length()) {
			System.out.println("String length is Mismatch.");
			flag = false;
			return flag;
		}

		char[] ch1 = s.toLowerCase().toCharArray();
		char[] ch2 = t.toLowerCase().toCharArray();

		String s1 = "";
		String s2 = "";

		for(char i='a';i<='z';i++) {

			for(int j=0;j<ch1.length;j++) {
				if(i==ch1[j]) {
					s1 += i;
				}
			}

			for(int k=0;k<ch2.length;k++) {
				if(i==ch2[k]) {
					s2 += i;
				}
			}

		}
		
		System.out.println(s1);
		System.out.println(s2);
		
		if(s2.equals(s1)) {
			flag = true;
		}else {
			flag = false;
		}
		return flag;
	}
	public static void main(String[] args) {
		StringAnagram anagram = new StringAnagram();

		String s = "anagram";
		String t = "nagaram";
		System.out.println(anagram.String_Anagram(s, t));

//		String s1 = "rat";
//		String t1 = "car";
//		System.out.println(anagram.String_Anagram(s1, t1));
	}
}