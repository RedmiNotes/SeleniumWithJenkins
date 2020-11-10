package com.logical.programs;

import java.util.Arrays;

public class Add_Two_Numbers {
	public int[] addTwoNumbers(int[] l1, int l2[]) {
		int sum = 0;
		int []n = new int[l1.length];
		for(int i=0;i<l1.length;i++) {
			for(int j=i;j<l2.length;) {
				sum = l1[i] + l2[j];
				break;
			}
			n[i] = sum;
		}
		return n;
	}
	public static void main(String[] args) {
		Add_Two_Numbers add = new Add_Two_Numbers();
		int[] l1 = {2,4,3};
		int l2[] = {5,6,4};
		int[] a = add.addTwoNumbers(l1, l2);
		System.out.println(Arrays.toString(a));
	}
}