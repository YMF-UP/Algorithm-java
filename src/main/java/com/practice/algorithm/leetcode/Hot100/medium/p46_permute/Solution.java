package com.practice.algorithm.leetcode.Hot100.medium.p46_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode .
 * 题目描述:
 * 示例:
 * 解题思路:1.最简单的一个回溯了
 *        2.还是差点意思啊我
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {

	/*private static  void  dfs(List<List<Integer>> list,int [] nums,boolean []bool,int cur){
		//应该是第一个位置 然后第二个位置这样一路下来
		//也就是我回溯的点是回到当前位置进行更换,那需要一个boolen函数

		//具体实现函数怎么写?
		*//*
		  1.传当前数组下的具体下标数据nums[i]
		  2.判断有没有访问,没有就进入,有就退出回溯回去继续
		 *//*
		if(!bool[cur]){
			return;
		}
		//如果没访问过的话,那就置为true,然后放入list里面
		bool[cur]=true;
		//这个是要用具体的list吗?

		//也就是说这个for循环是为了找下一个位置的
		for (int i = 0; i < nums.length; i++) {

		}

	}
	public List<List<Integer>> permute(int[] nums) {
		//这个说实话我不懂怎么去写入,List<List<Integer>>,不知道怎么用
		List<List<Integer>> list=new ArrayList<>();
		//回溯和状态,最重要的是--标记吗?怎么返回来着,每一个位置都需要所有的分别呆一遍.
		//回溯的关键是在于终止条件,每次结束之后应该是一个组合,单独传一个list吗?
		boolean [] bool=new boolean[nums.length];
		Arrays.fill(bool,false);
        dfs(list,nums,bool,nums[0]);
		return  list;
	}
*/

/*	private static void dfs(List<List<Integer>> ans,List<Integer> path,boolean[] is,int n,int [] nums,int k){

		if(k==n){
			ans.add(new ArrayList<>(path));
			return;
		}
		//for循环应该从哪里开始,从k还是都是0,从0开始,因为每一个都要进去成为一个排列
		for (int i = 0; i < n; i++) {
			if(!is[i]){
				is[i]=true;
				path.add(nums[i]);
				dfs(ans,path,is,n,nums,k+1);
				is[i]=false;
				path.remove(path.size()-1);
			}
		}


	}


	public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
		List<List<Integer>> ans =new ArrayList<>();
		List<Integer> path=new ArrayList<>();
		boolean [] is=new boolean[n];
		dfs(ans,path,is,n,nums,0);


        return ans;
	}*/

	private  static  void  dfs(int cur,List<List<Integer>> ans,List<Integer> path,boolean[] isvalid,int[] nums){
		//这个状态就是我要去遍历所有的
		if(cur==nums.length){
			ans.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(!isvalid[i]){
				isvalid[i]=true;
				path.add(nums[i]);
				dfs(cur+1,ans,path,isvalid,nums);
				isvalid[i]=false;
				path.remove(path.size()-1);
			}
		}

	}
	public List<List<Integer>> permute(int[] nums) {
        //我也不知道会不会了,感觉都是记忆,背下来了,不知其所以然
		//回溯--要看状态 处理 重置
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> path=new ArrayList<>();
        boolean[] isvalid=new boolean[nums.length];
		dfs(0,ans,path,isvalid,nums);
		return ans;

	}

}
