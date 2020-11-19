package com.selenium.practice;

public class String_Reverse {
	public String StringReverse_01(String s) {
		String s1[] = s.split(" ");
		String s2 = "";
		for(int i=s1.length-1;i>=0;i--) {
			if(s1[i].equals("\\s")) {

			}
			String s3 = " " + s1[i];
			s2 += s3;
		}
		return s2.trim();
	}
	public String StringReverse_02(String s) {
		String s1[] = s.split(" ");
		String s2 = "";
		for(int i=0;i<s1.length;i++) {
			String s3 = s1[i] + " ";
			for(int j=s3.length()-1;j>=0;j--) {
				s2 += s3.charAt(j);
			}
		}
		String s4 = s2.trim();
		return s4;
	}
	public static void main(String[] args) {
		String_Reverse reverse = new String_Reverse();
		String s = "the sky is blue";
		System.out.println(reverse.StringReverse_01(s));
		System.out.println(reverse.StringReverse_02(s));
	}
}