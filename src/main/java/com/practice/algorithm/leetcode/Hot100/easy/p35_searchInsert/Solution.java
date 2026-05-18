package com.practice.algorithm.leetcode.Hot100.easy.p35_searchInsert;

public class Solution {

	public int searchInsert(int[] nums, int target) {
		//我一开始还以为要整理数组呢,就是要插入--后来一看只需要返回就行了
		//问题的关键就在于向上取整还是向下取整
		//怎么返回来着
		int left=0;
		int right=nums.length-1;
		int mid=(left+right)/2;
        int flag=1;
		while (left<=right){
			mid=(left+right)/2;
			if(nums[mid]==target){
				return mid;
			} else if (nums[mid] > target) {
				right=mid-1;
				flag=1;
			}else {
				left=mid+1;
				flag=2;
			}
		}
        return flag==2 ?mid+1 :mid;
	}

}
