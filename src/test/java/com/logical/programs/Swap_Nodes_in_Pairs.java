package com.logical.programs;

import java.util.Arrays;

public class Swap_Nodes_in_Pairs {
	public int[] swapNode(int[] n) {
		int n1[] = new int[n.length];
		for(int i=0;i<n.length;i++) {
			if(i%2==0) {
				n1[i] = n[i+1];
			}else {
				n1[i] = n[i-1];
			}
		}
		return n1;
	}
	public static void main(String[] args) {
		Swap_Nodes_in_Pairs snp = new Swap_Nodes_in_Pairs();
		int[] node = {1,2,3,4};
		int[] a = snp.swapNode(node);
		System.out.println(Arrays.toString(a));
	}
}