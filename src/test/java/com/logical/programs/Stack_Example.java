package com.logical.programs;

import java.util.Stack;

public class Stack_Example {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean result = stack.empty(); 
		System.out.println("Is the stack empty? " + result);
		stack.push(78);  
		stack.push(113);  
		stack.push(90);  
		stack.push(120); 
		System.out.println(stack);
		result = stack.empty();
		System.out.println("Is the stack empty? " + result);
	}
}