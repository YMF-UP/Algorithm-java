package com.practice.algorithm.leetcode.Hot100.easy.p169_majorityElement;

public class Solution {

	public int majorityElement(int[] nums) {
		//这一题还真是从一开始到现在---
		//但是我记得下一题好像就稍微难一点,就是这一题的进阶题
		int flag=0;
		int cur=nums[0];
		for(int i:nums){
			if(i!=cur){
				flag--;
			}else {
				flag++;
			}
			if(flag==0){
				cur=i;
				flag++;
			}

		}
		return cur;
	}

}
