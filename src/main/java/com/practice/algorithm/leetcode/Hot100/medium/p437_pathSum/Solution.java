package com.practice.algorithm.leetcode.Hot100.medium.p437_pathSum;

import com.practice.algorithm.model.TreeNode;

/**
 * LeetCode 437.
 * 题目描述:
 * 示例:
 * 解题思路: 1.怎么说呢--有种似曾相识的感觉--在前面--但是我忘了
 *         2.绝对的dfs,就是剪枝和回溯--这样吧
 *         3.看标签没有回溯--这......哪里想错了吗
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {
    private  int sum=0;
	public int pathSum(TreeNode root, int targetSum) {
		if(root==null){
			return 0;
		}
		dfs(root,targetSum,0);
		pathSum(root.left,targetSum);
		pathSum(root.right,targetSum);
		return sum;
	}
	//两种情况考虑---1.到目标了怎么回溯?但是也有可能下面继续可以呢?;2.就是回溯怎么归为重新开始
	//传统dfs是从下往上脱离---这个是从上往下脱离。重新开始的方向相反
	private  void dfs(TreeNode root,int targetSum,int now){
		if(root==null){
			return ;
		}
		now+=root.val;
		if(now==targetSum){
			sum++;
		}
		dfs(root.left,targetSum,now);
        dfs(root.right,targetSum,now);
        //怎么去尝试root的左右--回到最初的root不太现实或者说必须回溯才行吧
	}
}
