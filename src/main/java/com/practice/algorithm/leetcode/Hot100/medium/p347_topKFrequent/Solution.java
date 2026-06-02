package com.practice.algorithm.leetcode.Hot100.medium.p347_topKFrequent;

import java.util.HashMap;

public class Solution {

	public int[] topKFrequent(int[] nums, int k) {

        //感觉和之前那个找最大的一样---就是维护一个哈希,频率--如果不是的话减一直到为0.
		//那就写一下
        int []ans=new int [k];
		HashMap<Integer,Integer> cur=new HashMap<>();
		for (int i:nums){
			//当size小于k的时候随便放,等于k的时候就要减一了---全减一吗?应该是全减一
			//是为0的时候当场踢走,还是下一次踢走?--当场踢走
			if(cur.size()<k){
				//加一
				cur.put(i,cur.)//语法还是不熟悉啊
			} else {
				//如果没在里面就全部减一,然后为0的踢走,这个不加入

			}
		}
        //把哈希写入数组里面
		return ans;
	}
}
