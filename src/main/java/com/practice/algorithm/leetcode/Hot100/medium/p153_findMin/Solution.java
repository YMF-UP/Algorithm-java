package com.practice.algorithm.leetcode.Hot100.medium.p153_findMin;

public class Solution {

	public int findMin(int[] nums) {
		//不对吧,怎么感觉和上一题一模一样啊.不对,应该说是我对上一题--33的理解和解法有问题.

        //旋转次数,最大n次,也急速没有旋转,和长度余一下就行了吧
		int l=0;
		int r=nums.length-1;
		int mid;
		while (l<=r){
			mid=l+(r-l)/2;
			if(nums[mid]>=nums[0]){
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		return nums[l%(nums.length)];
	}

}
