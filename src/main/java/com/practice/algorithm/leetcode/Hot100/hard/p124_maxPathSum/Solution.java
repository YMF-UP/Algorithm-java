package com.practice.algorithm.leetcode.Hot100.hard.p124_maxPathSum;

import com.practice.algorithm.model.TreeNode;

/**
 * LeetCode 124.
 * 题目描述: 找最大路径和---但是起点不确定,只要最大就可以
 * 示例:
 * 解题思路: 1.还真没有思路,确实没有什么思路---起点怎么确定?
 *         2.为负数就不行吗,那不是----突然想到一个类似的题,想不起来了,干---也是这样求最大和,前面的hot100里面的
 *         3.就一直往前走,不够这个应该也是---不是不够而是方向问题--和为0或者负数就停下---不对为负数了呢?
 *         4.为负数就停下,最新的开始
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {
    private int maxSum=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
         //现在的问题就是方向---每个节点只能出现一次
		 //根左--根右--左根右,只有这三个方向了
		 //但是当前是决定不了的吧---就是方向
		//递归---条件、返回值
        sum(root);
		return maxSum;
	}
	private int sum(TreeNode root)
	{
		//这是递归结束的判断---还要加一个判断才对啊
		//加一个maxsum的判断
		 if(root==null){
			return 0;
		}
		 //递归有一个问题,就是只能有一个左根右--返回的时候这方面怎么判断和去除--就这个卡住了
		int left=sum(root.left);
		int right=sum(root.right);
        maxSum=Math.max(maxSum,left+right+root.val);//v形,转弯的--不仅仅,还要那种全负的
		return Math.max(Math.max(left,right)+root.val,0);//链式
	}
}
