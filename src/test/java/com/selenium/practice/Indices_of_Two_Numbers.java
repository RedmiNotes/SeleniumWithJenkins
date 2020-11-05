package com.selenium.practice;

public class Indices_of_Two_Numbers {
	public int[] twoSum(int[] n, int num) {
		int[] n1 = new int[2];
		for (int i=0;i<n.length;i++) {
			for(int j=i+1;j<n.length;j++) {
				if(num ==(n[i]+n[j])) {
					n1[0] = i;
					n1[1] = j;
					System.out.println("[" + n1[0] + ", " + n1[1] + "]");
				}
			}
		}
		return n1;
	}

	public static void main(String[] args) {
		int[] s = {2, 7, 11, 15};
		int value = 26;
		new Indices_of_Two_Numbers().twoSum(s,value);
	}
}