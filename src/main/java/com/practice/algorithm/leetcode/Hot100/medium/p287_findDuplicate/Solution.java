package com.practice.algorithm.leetcode.Hot100.medium.p287_findDuplicate;

public class Solution {

	public int findDuplicate(int[] nums) {
         int flag=0;
		 int k=nums[0];
		 //怎么感觉这一题又想摩尔投票啊,这家伙怎么又来了,当时Topk的时候就在这么想,吐了,好像是我只会这个
		 //因为要求常数个空间啊--所以我才想到搞摩尔投票的思想的啊--不行的,不能抵消
		 //因为圈定了只有一个重复,所以可以用和来判断,很好吧
		int sum=0;
		for (int i = 1; i < nums.length; i++) {
            sum+=i;
		}
		for (int i:nums){
			if(k==i){
				flag=1;
			}else {
				flag=0;
			}
			sum-=i;
		}
         //确实还有一种情况是都是一个数的时候
		 return flag==0 ? 0-sum:nums[0];
	}
}
