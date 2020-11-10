package com.logical.programs;

import java.util.*;

public class Letter_Combination_of_Phone_Number {
	Map<String, String> phone = new HashMap<String, String>();
	List<String> output = new ArrayList<String>();
	public void backtrack(String combination, String next_digits) {
		phone.put("2", "abc");
		phone.put("3", "def");
		phone.put("4", "ghi");
		phone.put("5", "jkl");
		phone.put("6", "mno");
		phone.put("7", "pqrs");
		phone.put("8", "tuv");
		phone.put("9", "wxyz");	
		if (next_digits.length() == 0) {
			output.add(combination);
		}
		else {
			String digit = next_digits.substring(0, 1);
			String letters = phone.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter = phone.get(digit).substring(i, i + 1);
				backtrack(combination + letter, next_digits.substring(1));
			}
		}
	}
	public List<String> letterCombinations(String digits) {
		if (digits.length() != 0)
			backtrack("", digits);
		return output;
	}
	public static void main(String[] args) {
		Letter_Combination_of_Phone_Number letterphone = new Letter_Combination_of_Phone_Number();
		String digits = "23";
		System.out.println(letterphone.letterCombinations(digits));
	}
}