package com.practice.algorithm.leetcode.Hot100.medium.p198_rob;

public class Solution {

	public int rob(int[] nums) {
		int max=0;
		//就像是背包问题的一个变种,本质还是放不放
		//背包是每次碰到要不要拿---但是我忘了为什么是二维数组了
		//这个也是每碰到一个就去判断拿了这个和最大的比,也就是要保留前面的状态,因为不能临近
		//所以就是拿,拿了再说,前两个状态下
		//需要二维数组吗?---背包为什么需要呢?
		int n=nums.length;
		int[] ans=new int[n];
		for (int i = 0; i < n; i++) {
			if(i>1){
				ans[i]=nums[i]+ans[i-2];
			}else {
				ans[i]=nums[i];
			}
			if(ans[i]>max){
				max=ans[i];
			}
		}

		return max;

	}



}
