package com.selenium.practice;

import java.util.*;

public class MaximunSubArray {
	public int[] subArray(int[] n,int k) {
		int[] n3 = new int[k];
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		List<Integer> list3 = new ArrayList<Integer>();
		for(int i=0;i<n.length;i++) {
			List<Integer> list2 = new ArrayList<Integer>();
			for(int j=i;j<n.length;j++) {
				int n1 = n[j];
				list2.add(n1);
				if(list2.size()==k) {
					break;	
				}
			}
			list1.add(list2);
		}
		for(int i=0;i<list1.size();i++) {
			int sum1 = 0;
			for(int j=0;j<list1.get(i).size();j++) {
				sum1 += list1.get(i).get(j);
			}
			list3.add(sum1);
		}
		int x = Collections.max(list3);
		for(int i=0;i<list1.size();i++) {
			int sum2 = 0;
			for(int j=0;j<list1.get(i).size();j++) {
				sum2 += list1.get(i).get(j);
			}
			if(x==sum2) {
				for(int l=0;l<k;l++) {
					n3[l] = list1.get(i).get(l);
				}
			}
		}
		return n3;
	}
	public static void main(String[] args) {
		MaximunSubArray maxsubarray = new MaximunSubArray();
		int[] n = {4,5,11,2,13,-4,12};
		int k = 3;
		System.out.println(Arrays.toString(maxsubarray.subArray(n,k)));
	}
}