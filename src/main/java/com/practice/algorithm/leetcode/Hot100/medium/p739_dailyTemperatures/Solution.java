package com.practice.algorithm.leetcode.Hot100.medium.p739_dailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public int[] dailyTemperatures(int[] temperatures) {

		int [] ans=new int[temperatures.length];
        //我突然想到了一个东西--这一题也好,其他题也好,共同点就是--分析状况,确认有几种状态,考虑边界.实际业务也是这样吗?
        //这个状况就是--1.下一个就是大于的;2.下一个不是,之后才是;3.没有出现更大的了
		//如果进来一个就比较栈的话,时间复杂度会很大啊---O(n平方)了.---但是我确实想不到其他的了
		Deque<int []> deque=new ArrayDeque<>();
		deque.push(new int[]{temperatures[0],0});
		for (int i = 1; i < temperatures.length; i++) {
			for (int j = 0; j < deque.size(); ) {
				  int a=deque.peek()[0];
				  int b=deque.peek()[1];
				  if(temperatures[i]>a){
					  //我需要当前的位置信息,就是具体下标,不然处理不了--像前面那样,搞个int[]类型吗?
                     ans[b]=i-b;
                     deque.pop();//这样会不会导致有问题,两边收缩的话
				  }else {
					  break;
				  }
			    }
			deque.push(new int[]{temperatures[i],i});
		}
		return ans;

	}

}
