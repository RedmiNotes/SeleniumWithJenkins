package com.selenium.practice;

import java.io.*;
import java.util.*;

public class Practice {
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> list = new ArrayList<>();
		int sum1 = 0;
		int sum3 = 0;
		int j = 0;
		for(int i=0;i<a.size();i++) {
			while(0<b.size()) {
				if(a.get(i)>b.get(j)) {
					sum1 = sum1 + 1;
				}else if(a.get(i)==b.get(j)) {
				}else if(a.get(i)<b.get(j)) {
					sum3 = sum3 + 1;
				}
				j++;
				break;
			}
		}
		list.add(sum1);
		list.add(sum3);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] n1 = new int[n];
		List<Integer> a = new ArrayList<>();
		for(int i=0;i<n;i++){
			n1[i] = scan.nextInt();
			a.add(n1[i]);
		}

		int[] n2 = new int[n];
		List<Integer> b = new ArrayList<>();
		for(int i=0;i<n;i++){
			n2[i] = scan.nextInt();
			b.add(n2[i]);
		}
		compareTriplets(a, b);
		scan.close();
	}
}