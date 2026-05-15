package com.practice.algorithm.leetcode.Hot100.medium.p79_exist;



public class Solution {

	private static final int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
	private static final int n=direction.length;
	private static boolean dfs(char[][] board, String word,int dir,StringBuilder path,int i,int j,int num){
        boolean result;
		if(i<0||i>=board.length||j<0||j>=board[0].length||num!=path.length()){
			return false;
		}
		if(path.equals(word)){
			  return true;
          }
		 //感觉还缺一个遍历循环
          for (int [] cur:direction){
			  //dir怎么进行淘汰呢?就是不能走反方向了
	          //而且我还差一个大循环
			  if(board[i][j]==word.charAt(num)){
				 path.append(board[i][j]);
                 i+=cur[0];
			     j+=cur[1];

		     }
		  }

	}
	public boolean exist(char[][] board, String word) {
		//感觉像是n皇后的简略版,暴力肯定好写一些,问题就是剪枝
		//剪枝就是不要走重复的路---为什么我想到了kmp
        StringBuilder path=new StringBuilder();
        int i=0,j=0;
		for (;i<board.length;i++){
			for (;j<board[0].length;){

			}
		}

		return dfs(board,word,0,path,0,0,0);
	}

}
