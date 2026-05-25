package com.practice.algorithm.leetcode.Hot100.medium.p46_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode .
 * 题目描述:
 * 示例:
 * 解题思路:1.最简单的一个回溯了
 *        2.还是差点意思啊我
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {

	private static  void  dfs(List<List<Integer>> list,int [] nums,boolean []bool,int cur){
		//应该是第一个位置 然后第二个位置这样一路下来
		//也就是我回溯的点是回到当前位置进行更换,那需要一个boolen函数

		//具体实现函数怎么写?
		/*
		  1.传当前数组下的具体下标数据nums[i]
		  2.判断有没有访问,没有就进入,有就退出回溯回去继续
		 */
		if(!bool[cur]){
			return;
		}
		//如果没访问过的话,那就置为true,然后放入list里面
		bool[cur]=true;
		//这个是要用具体的list吗?

		//也就是说这个for循环是为了找下一个位置的
		for (int i = 0; i < nums.length; i++) {

		}

	}
	public List<List<Integer>> permute(int[] nums) {
		//这个说实话我不懂怎么去写入,List<List<Integer>>,不知道怎么用
		List<List<Integer>> list=new ArrayList<>();
		//回溯和状态,最重要的是--标记吗?怎么返回来着,每一个位置都需要所有的分别呆一遍.
		//回溯的关键是在于终止条件,每次结束之后应该是一个组合,单独传一个list吗?
		boolean [] bool=new boolean[nums.length];
		Arrays.fill(bool,false);
        dfs(list,nums,bool,nums[0]);
		return  list;
	}
}
