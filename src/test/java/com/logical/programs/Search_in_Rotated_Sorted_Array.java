package com.logical.programs;

public class Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
		int n = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==target) {
				n = i;
			}
		}
		if(n==0) {
			return -1;
		}
		return n;
	}
	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array search_val = new Search_in_Rotated_Sorted_Array();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 10;
		System.out.println(search_val.search(nums, target));
	}
}