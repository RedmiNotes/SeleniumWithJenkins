package com.selenium.practice;

public class Total_Number_of_Continuous_SubArray {
	public int totalNumberofContinousSubrray_01(int[] num, int k) {
		int count = 0; 
		for (int i = 0; i < num.length; i++) { 
			if(k==num[i])
				count++;
			for (int j = i+1; j < num.length; j++) {
				if ((num[i] + num[j]) == k) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	public int totalNumberofContinousSubrray_02(int[] num, int k) {
		int count = 0;
		for(int i=0;i<num.length;i++) {
			if(k==num[i]) {
				count++;
			}
		}
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(k==(num[i]+num[j])) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Total_Number_of_Continuous_SubArray total_number = new Total_Number_of_Continuous_SubArray();
		int n[] = {1,1,1};
		int k = 2;
		int n1[] = {1,2,3};
		int k1 = 3;
		System.out.println("The Value is : " + total_number.totalNumberofContinousSubrray_01(n, k));
		System.out.println("----------------");
		System.out.println("The Value is : " + total_number.totalNumberofContinousSubrray_02(n1, k1));
	}
}