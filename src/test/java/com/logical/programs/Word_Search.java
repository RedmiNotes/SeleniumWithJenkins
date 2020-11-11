package com.logical.programs;

public class Word_Search {
	public boolean exist(char[][] board, String word) {
		boolean flag = false;
		char[] s1 = word.toCharArray();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<s1.length;k++) {
					if(s1[k]==board[i][j]) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Word_Search ws = new Word_Search();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCDE";
		//ws.exist(board, word);
		System.out.println(ws.exist(board, word));
	}
}