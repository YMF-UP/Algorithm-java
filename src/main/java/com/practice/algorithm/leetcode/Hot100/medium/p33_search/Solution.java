package com.practice.algorithm.leetcode.Hot100.medium.p33_search;

public class Solution {

	public int search(int[] nums, int target) {

		//有意思啊---没有给k,然后要旋转后的下标
		//现在的关键点就是先找分开旋转的k点,然后去确认区间然后二分
		//思路倒是挺简单和清晰的
		//其实和上面34很像一方面.
		//就是说明了是旋转的,那旋转后的第一个肯定能找到第一个小于它的,那就是分界k点
		int k=find(nums,0,nums.length-1,nums[0]);
		//然后开始二分寻找
		if(target>=nums[0]){
            return find(nums,0,k-1,target);
		}else {
			return find(nums,k,nums.length-1,target);
		}
	}

	private static int find(int[] nums,int l,int r,int target) {
		int mid;
		//还是双闭区间就是符合我的思路,其余的之后再看吧
		//找到第一个小于nums[0]的下标
		while (l<=r){
			mid=l+(r-l)/2;
			if(nums[mid]>=target){
               l=mid+1;
			}
			else {
                r=mid-1;
			}
		}
		if(l==nums.length){
			return  -1;
		}
		return nums[l]<=target ? l :-1;
	}

}
