package com.practice.algorithm.leetcode.Hot100.medium.p78_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/*private static void dfs(List<List<Integer>>  ans,boolean [] bool,int i,int n){
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
*/

	private static void dfs(List<List<Integer>>  ans,List<Integer> path,boolean [] bool,int k,int n){

		//子集不知道怎么判定,不能是用Boolean函数了吧,
		//子集的关键点也变成了什么时候放,肯定也是走完的时候.但是怎么放呢?
		//肯定不可能是像全排列一个一个放,怎么全部漏掉呢?

		if(k==n){
			ans.add(new ArrayList<>(path));
			return;
		}
		//就是不知道什么时候放,什么时候丢
		//子集的关键是什么,
		for (int j = k; j <n ; j++) {

			dfs(ans,path,bool,j+1,n);

		}

	}
	public List<List<Integer>> subsets(int[] nums) {
		//感觉和46一样啊---就是集合变了
		int n=nums.length;
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> path=new ArrayList<>();
		//这个终止条件就变了,list也不应该是覆盖了
		boolean[] bool=new boolean[n];
		dfs(ans,path,bool,0,n);
		return ans;
	}




}
