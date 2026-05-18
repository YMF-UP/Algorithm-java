package com.practice.algorithm.leetcode.Hot100.hard.p51_solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	//纯粹模板题,记得之前很容易就写出来了,很模板化,之前考研的时候了
	/*private static boolean is(int i,int j,int n,boolean[]list){
        //开始判断是否能填入
		//行列都好判断,主要是斜着的,只判断列就行了吗?
		if(i==0){
			return true;
		}
		for (int k = 0; k < n; k++) {
			if(!list[j+k]&&!list[j-k]){
				return true;
			}
		}
		return false;
	}*/
	private static void dfs(int row,int i, boolean[] col, boolean [] dig1,boolean [] dig2,int[]queens,List<String> path, List<List<String>>ans){
		int n=col.length;
		if(row==n){
			path.clear();
			for (int c:queens){
				char[] s=new char[n];
				Arrays.fill(s,'.');
				s[c]='Q';
				path.add(new String(s));
			}
			ans.add(new ArrayList<>(path));
			return;
		}
		//递归的话,可以只考虑这一行的,其余不考虑,只排列就行了,但传的话,要传下一行
		for (int j = 0; j < n; j++) {
            int rc=row-j+n-1;//主对角线
            if(!dig1[rc]&&!dig2[row+j]&&!col[j]){
				queens[row]=j;
                dig1[rc]=dig2[row+j]=col[j]=true;
	            dfs(row+1,j, col,dig1,dig2,queens,path,ans);
	            dig1[rc]=dig2[row+j]=col[j]=false;
            }
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans=new ArrayList<>();
		List<String> path=new ArrayList<>();
		boolean [] dig1=new boolean[2*n-1];
		boolean [] dig2=new boolean[2*n-1];
		boolean [] col =new boolean[n];
		int[] queens=new int[n];
		//第一行---不行就是不行
		dfs(0,0,col,dig1,dig2,queens,path,ans);
		return ans;
	}
}
