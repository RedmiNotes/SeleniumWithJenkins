package com.selenium.practice;

import java.util.*;

public class Longest_Consecutive_Sequence {
	public int conlen(int []num) {
		int len = 1;
		System.out.println();
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[i]==num[j])
					break;
				int n1 = num[i] + 1;
				int n2 = num[j];
				if(n1==n2) {
					len++;
				}
			}
		}
		return len;
	}
	public int longestConsecutive_01(int[] num) {
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[i]>num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
			System.out.print(num[i] + " ");
		}
		return conlen(num);
	}
	public int longestConsecutive_02(int[] num) {
		Arrays.sort(num);
		for(int n : num) {
			System.out.print(n + " ");
		}
		return conlen(num);
	}
	public int longestConsecutive_03(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int n : num) {
			set.add(n);
		}
		int len = 0;
		for (int i : num) {
			int length = 1;
			for (int j = i - 1; set.contains(j); --j) {
				set.remove(j);
				++length;
			}
			for (int j = i + 1; set.contains(j); ++j) {
				set.remove(j);
				++length;
			}
			len = Math.max(len, length);
		}
		return len;
	}
	public static void main(String[] args) {
		Longest_Consecutive_Sequence lcs = new Longest_Consecutive_Sequence();
		int[] n = {100,4,200,1,3,2};
		System.out.println(lcs.longestConsecutive_01(n));
		System.out.println("----------------");
		System.out.println(lcs.longestConsecutive_02(n));
		System.out.println("----------------");
		System.out.println(lcs.longestConsecutive_03(n));
	}
}