package com.practice.algorithm.leetcode.Hot100.easy.p121_maxProfit;

public class Solution {

	public int maxProfit(int[] prices) {
		//之前做过--哈哈,这个的印象深刻,但更深刻的是它的进阶题---非常难啊

		//贪心和dp两个都可以,但是进阶题好像只能用dp--dp还是不会啊
		int max=0;
		int p=prices[0];
		for (int cur:prices){
			//买入价格和卖出时间
			//买入价格可以随时变,只要小于当前买入就可以,卖出就一直计算
			if(p>cur){
				p=cur;//买入变了
			}
            if(p<cur){
	            max = Math.max(max, cur - p);
            }

		}

       return max;
	}

}
