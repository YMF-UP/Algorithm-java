package com.practice.algorithm.leetcode.Hot100.medium.p55_canJump;

public class Solution {

	/*private static boolean dfs(int cur,int n,int []nums){

		if(cur==n){
			return true;
        }
		for (int i = 1; i <=nums[cur] ; i++) {
              dfs(cur+i,n,nums);
		}

		return false;
	}

	public boolean canJump(int[] nums) {
		//这个确实很贪心--就是只考虑当前最优
		//越来越感觉贪心就是普通模拟了,有什么区别吗?--我没发觉出来
		//这个跳跃--就是从大到小进行模拟?--这是回溯啊
        int n=nums.length-1;
		return dfs(0,n,nums);
	}*/

	public boolean canJump(int[] nums) {

		int cur=0;
		int n=nums.length-1;
		if(n==0){
			return true;
		}
		for (int i = 0; i <n; i++)

		{
			if(i<cur){
			cur=Math.max(cur,i+nums[i]);
		     }
			if(i==cur){
				cur=i+nums[i];
			}
			if(cur==0){
				return false;
			}
			if(cur>=n){
				return true;
			}
		}

		return  false;

	}

}
