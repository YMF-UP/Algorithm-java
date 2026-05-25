package com.practice.algorithm.leetcode.Hot100.medium.p78_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static void dfs(List<List<Integer>>  ans,boolean [] bool,int i,int n){
		 //这个也就没有终止条件了,因为状态的终止是和新一个子集合并了
		 //不对,还是要有啊
		 if(bool[i]){
			 return;
		 }
		 for (int j = 0; j <n ; j++) {
			 //这个也是i+1吗?46题是因为要把全部的都放到集合里面
			 dfs(ans,bool,i+1,n);
		 }

	}
	public List<List<Integer>> subsets(int[] nums) {
		//感觉和46一样啊---就是集合变了
		int n=nums.length;
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> son=new ArrayList<>();
		//这个终止条件就变了,list也不应该是覆盖了
		boolean[] bool=new boolean[nums.length];
        dfs(ans,bool,0,n);
        return ans;
	}



}
