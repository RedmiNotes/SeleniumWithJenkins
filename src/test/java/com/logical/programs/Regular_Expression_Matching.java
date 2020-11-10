package com.logical.programs;

public class Regular_Expression_Matching {
	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) return text.isEmpty();
		boolean first_match = (!text.isEmpty() &&
				(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
			return (isMatch(text, pattern.substring(2)) ||
					(first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}
	public static void main(String[] args) {
		Regular_Expression_Matching rexp = new Regular_Expression_Matching();
		String s = "aa";
		String p = ".*";
		System.out.println(rexp.isMatch(s, p));
	}
}