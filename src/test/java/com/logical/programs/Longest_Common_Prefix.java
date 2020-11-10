package com.logical.programs;

public class Longest_Common_Prefix {
	public String commonPrefix(String[] strs) {
		String s1 = null;
		for(int i=0;i<strs.length;i++) {
			for(int j=i+1;j<strs.length;j++) {
				char[] ch1 = strs[i].toCharArray();
				char[] ch2 = strs[j].toCharArray();
				s1 = "";
				for(int a=0;a<ch1.length;a++) {
					for(int b=0;b<ch2.length;b++) {
						if(ch1[a]==ch2[b]) {
							s1 += ch1[a];
						}
					}
				}
			}
		}
		System.out.println(s1);
		return s1;
	}
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	public static void main(String[] args) {
		Longest_Common_Prefix prefix = new Longest_Common_Prefix();
		String strs[] = {"once","once","oncs","oncion","onc","oncly"};
		prefix.commonPrefix(strs);
		System.out.println(prefix.longestCommonPrefix(strs));
	}
}