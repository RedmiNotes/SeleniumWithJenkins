package com.selenium.practice;

public class Distinct_Integer {
	public int distinctInteger_01(int[] num,int target) {
		int j = 0;
		for(int i=0;i<num.length;i++) {
			if(num[i]==target) {
				j = i;
			}else if(target>num[i]) {
				j = i+1;
			}
		}
		System.out.println("The Distinct Intex Value is : " + j);
		return j;
	}
	public int distinctInteger_02(int[] nums, int target) {
		int i=0; 
		int j=nums.length-1;
		while(i<=j){
			int mid = (i+j)/2;
			if(target > nums[mid]){
				i=mid+1;
			}else if(target < nums[mid]){
				j=mid-1;
			}else{
				return mid;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		Distinct_Integer distinctinteger = new Distinct_Integer();
		int[] n1 = {1,3,5,6};  int target1 = 5; // → 2
		int[] n2 = {1,3,5,6};  int target2 = 2; // → 1
		int[] n3 = {1,3,5,6};  int target3 = 7; // → 4
		int[] n4 = {1,3,5,6};  int target4 = 0; // → 0
		distinctinteger.distinctInteger_01(n1,target1);
		distinctinteger.distinctInteger_01(n2,target2);
		distinctinteger.distinctInteger_01(n3,target3);
		distinctinteger.distinctInteger_01(n4,target4);
		System.out.println("--------------------------------");
		System.out.println("Index Value is : " + distinctinteger.distinctInteger_02(n1,target1));	
		System.out.println("Index Value is : " + distinctinteger.distinctInteger_02(n2,target2));
		System.out.println("Index Value is : " + distinctinteger.distinctInteger_02(n3,target3));
		System.out.println("Index Value is : " + distinctinteger.distinctInteger_02(n4,target4));
	}
}