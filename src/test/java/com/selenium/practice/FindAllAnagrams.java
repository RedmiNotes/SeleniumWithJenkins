package com.selenium.practice;

import java.util.*;

public class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {

		/**
		 *  Split the String (s) based on (p) length
		 *  (E.x) : String s = "cbaebabacd" 
		 *          String p = "abc"
		 *          p length = 3
		 *          cbaebabacd = [cba, bae, aeb, eba, bab, aba, bac, acd]
		 */
		List<String> list1 = new ArrayList<String>();
		int n1 = s.length();
		int n2 = p.length();
		char []ch1 = s.toLowerCase().toCharArray();
		char []ch2 = p.toLowerCase().toCharArray();
		for(int i=0;i<n1;i++) {
			String s1 = "";
			for(int j=i;j<n1;j++) {
				s1 += ch1[j];
				if(s1.length()==n2) {
					list1.add(s1);
					break;
				}
			}
		}
		//System.out.println(list1);


		/**
		 *  Sort the Splited String
		 *  (E.x) : [cba, bae, aeb, eba, bab, aba, bac, acd]
		 *                           to
		 *          [abc, abe, abe, abe, abb, aab, abc, acd]
		 */
		List<String> list2 = new ArrayList<String>();
		for(int i=0;i<list1.size();i++) {
			char[] ch = list1.get(i).toCharArray();
			String s2 = "";
			for(char j='a';j<'z';j++) {
				for(int k=0;k<ch.length;k++) {
					if(j==ch[k]) {
						s2 += ch[k];
					}
				}
			}
			list2.add(s2);
		}
		//System.out.println(list2);


		/**
		 * Sort the String (p) 
		 * (E.x) :   acb
		 *           to
		 * 			 abc
		 */
		List<String> list3 = new ArrayList<String>();
		String s3 = "";
		for(char i='a';i<'z';i++) {
			for(int j=0;j<ch2.length;j++) {
				if(ch2[j]==i) {
					s3 += ch2[j];
				}
			}
		}
		list3.add(s3);
		//System.out.println(list3);


		/**
		 *  Compare Splited String (s) and String (p)
		 *  (E.x) :  [abc, abe, abe, abe, abb, aab, abc, acd]
		 *                       equals
		 *                        [abc]
		 *           the index value is [0, 6]             
		 */
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<list2.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list2.get(i).equals(list3.get(j))) {
					list.add(i);
				}
			}
		}
		return list;
	}


	public static void main(String[] args) {
		FindAllAnagrams allanagram = new FindAllAnagrams();
		String s =  "cbaebabacd";
		String p =  "ab";
		List<Integer> anagram =  allanagram.findAnagrams(s, p);
		System.out.println(anagram);
	}
}