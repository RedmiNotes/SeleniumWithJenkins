package com.selenium.practice;

import java.util.*;
import java.util.Map.Entry;

public class Open_brackets_must_be_closed_by_the_same_type_of_brackets {
	public boolean validParen(String input) {
		boolean flag = false;
		if(input.isEmpty() || input.equals(" ")) {
			flag = false;
			return flag;
		}
		Map<Character,Character> map = new TreeMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		char[] ch = input.toCharArray();
		for(Entry<Character, Character> e : map.entrySet()) {
			char key = e.getKey();
			int i = 0;
			while(i<ch.length) {
				if(ch[i]==key) {
					char val = e.getValue();
					if(input.contains(String.valueOf(val))) {
						flag = true;
					}else {
						flag = false;
						break;
					}
				}
				i++;
			}
		}
		return flag;
	}
	public boolean isValid(String str) {    
	    Map<Character, Character> parenthesesMapping = new HashMap<>();
	    parenthesesMapping.put('(', ')');
	    parenthesesMapping.put('{', '}');
	    parenthesesMapping.put('[', ']');
	    Stack<Character> parentheses = new Stack<>();
	    for(int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if(parenthesesMapping.containsKey(c)) {
	            parentheses.push(c);
	        } else {
	            if(parentheses.isEmpty()) {
	                return false;
	            }
	            char target = parentheses.pop();
	            if(!parenthesesMapping.containsKey(target) || parenthesesMapping.get(target) != c) {
	                return false;
	            }
	        }
	    }
	    if(!parentheses.isEmpty()) {
	        return false;
	    }
	    return true;
	  }
	public static void main(String[] args) {
		Open_brackets_must_be_closed_by_the_same_type_of_brackets bracket = new Open_brackets_must_be_closed_by_the_same_type_of_brackets();
		System.out.println(bracket.isValid("()"));        
		System.out.println(bracket.isValid("()[]{}"));      
		System.out.println(bracket.isValid("([{{}])"));        
	}
}