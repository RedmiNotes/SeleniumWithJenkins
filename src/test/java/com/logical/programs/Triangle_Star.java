package com.logical.programs;

public class Triangle_Star {
	public static void main(String[] args) {
		int k=1;
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=k;j++) {
				System.out.print(" * ");
			}
			k++;
			System.out.println();
		}
	}
}