package com.logical.programs;

public class String_to_Integer {
	public int myAtoi(String s) {
		int n = 0;
		String[] s1 = s.split(" ");
		char[] ch = s1[0].toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(Character.isDigit(ch[i]) || ch[i]=='-') {
				n = Integer.parseInt(s1[0]);
			}else {
				return 0;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		String_to_Integer stoi = new String_to_Integer();
		String str = "-42";
		System.out.println(stoi.myAtoi(str.trim()));
	}
}