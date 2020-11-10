package com.logical.programs;

import java.util.Arrays;

public class Two_Num {
	public int[] twoSum(int[] numbers, int target) {
		int tail = numbers.length-1;
		int[] n = new int[2];
		for (int i=0;i<tail;i++) {
			for(int j=i+1;j<tail;j++) {
				if(target ==(numbers[i]+numbers[j])) {
					n[0] = i;
					n[1] = j;
				}
			}
		}
		return n;
	}
	public static void main(String[] args) {
		int[] s = {2,7,11,15};
		int value = 9;
		Two_Num r = new Two_Num();
		int[] a = r.twoSum(s,value);
		System.out.println(Arrays.toString(a));
	}
}