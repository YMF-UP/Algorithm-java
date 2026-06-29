package com.practice.algorithm.leetcode.Hot100.medium.p45_jump;

public class Solution {

	public int jump(int[] nums) {
	   if(nums.length==1){
		   return 0;
	   }
       int min=1;
	   int n=nums.length-1;
	   int cur=0;
	   //这个就需要回溯了吧,因为一定可以走到的话,那肯定需要最大的几步
	   //每一次走最大的--还是说判断下一步走哪几步是走的最大的
	   //上一题是按照最大的步数能不能当前下标--这个真的很妙啊
       //那这一题呢?
		while (cur<=n)
		{
			//首先就是判断是不是能达到
			if(cur+nums[cur]>=n){
				break;
			}
			int max=0;
			//就是判断cur应该是哪个了--下一步去哪个下标更好
			for (int j = nums[cur]; j >=1 ; j--) {
				//好像不太对,cur是当前下标位置,最后还是要有cur的啊,还是说不要cur了,必须要啊,不然怎么走循环啊
				//max=Math.max(nums[j]+cur,max);
				if(j+nums[j+cur]>max){
					max=nums[j+cur]+j;
					cur+=j;
				}
			}
            min+=1;
		}
	   return min;
	}

}
