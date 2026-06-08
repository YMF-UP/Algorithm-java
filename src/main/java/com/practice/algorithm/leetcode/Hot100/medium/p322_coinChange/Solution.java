package com.practice.algorithm.leetcode.Hot100.medium.p322_coinChange;

import java.util.Arrays;

public class Solution {

	public int coinChange(int[] coins, int amount) {
        //这个之前好像做过,但是不是dp做的,我记得是纯模拟
		//可以重复选这个--上一题那个完全平方数的重复选是真牛啊
		//为什么感觉还完全平方数很像啊
		//本质好像都是选不选--只要和dp扯在一起的话
        int []ans=new int[amount+1];
		Arrays.fill(ans,Integer.MAX_VALUE);
		for (int i = 0; i <coins.length; i++) {
			for (int j=coins[i];j<=amount;j++){
				ans[j]=Math.min(ans[j],ans[j-coins[i]]+1);
			}
		}

		return ans[amount];
	}

}
