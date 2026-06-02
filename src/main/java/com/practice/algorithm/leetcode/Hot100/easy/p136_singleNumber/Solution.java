package com.practice.algorithm.leetcode.Hot100.easy.p136_singleNumber;

public class Solution {

	public int singleNumber(int[] nums) {
        //常数个空间复杂度的话还要求线性时间复杂度,果然是技巧啊--我没想到怎么做,没思路在这两个要求下
		//难点就在于说如果前面出现第一个的话怎么处理,哦,反向摩尔投票
		//开始记录,但是常数个空间不一定---既然其他都是2个,n/2个,不行,这样还是不能常数个啊

		int target=0;



        return target;
	}

}
