package com.practice.algorithm.leetcode.Hot100.medium.p17_letterCombinations;


import java.util.ArrayList;
import java.util.List;

public class Solution {
	//先写一下39啊--等会儿再写17
	private  static void dfs(List<List<Integer>> ans,List<Integer> path,int [] can,int target,int start){
		if(target==0){
			ans.add(new ArrayList<>(path));
			return;
		}
		if(target<0){
			return;
		}
		//选还是不选
		for (int i = start; i < can.length; i++) {
			if(target-can[i]>=0){
			path.add(can[i]);
			dfs(ans,path,can,target-can[i],i);
			path.remove(path.size() - 1);

			}
		}

	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> path=new ArrayList<>();
		dfs(ans,path,candidates,target,0);
		return ans;
	}
}
