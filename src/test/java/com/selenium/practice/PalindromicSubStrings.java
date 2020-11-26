package com.selenium.practice;
import java.util.*;
public class PalindromicSubStrings {
	public static void expand(String str, int low, int high, Set<String> set) {
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			set.add(str.substring(low, high + 1));
			low--;
			high++;
		}
	}
	public Set<String> allPalindromicSubStrings_01(String str) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			expand(str, i, i, set);
			expand(str, i, i + 1, set);
		}
		return set;
	}
	public Set<String> allPalindromicSubStrings_02(String s) {
		Set<String> set = new LinkedHashSet<String>();
		for (int i = 0; i <= 2*(s.length())-1; i++) {
			int left = i / 2;
			int right = left + i % 2;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				set.add(s.substring(left, right + 1));
				left--;
				right++;
			}
		}
		return set;
	}
	public static void main(String[] args) {
		String str = "google";
		System.out.println(new PalindromicSubStrings().allPalindromicSubStrings_01(str));
		System.out.println(new PalindromicSubStrings().allPalindromicSubStrings_02(str));
	}
}