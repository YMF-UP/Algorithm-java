package com.practice.algorithm.leetcode.Hot100.medium.p236_lowestCommonAncestor;

import com.practice.algorithm.model.TreeNode;

/**
 * LeetCode 236.
 * 题目描述:1.通过率这么高吗?
 * 示例:
 * 解题思路:1.第一反应就是并查集啊---对不对
 *        2.不一样的点就在于可以是当前的节点而不一定是范围最大的
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//算是三种情况---1.p是q的祖先;2.q是p的祖先;3.第三个共同祖先
		//怎么记忆节点--看当前节点的左右后代是否同时包括了p和q;如果本身此节点就是其中一个的话,那就看后代
		//这么来看就是双层递归--每一个节点吗?--应该可以提前结束吧--暂时没想到

		/// 分情况考虑关键
		if(root==null||root==p||root==q){
			return root;
		}
		TreeNode left=lowestCommonAncestor(root.left, p,q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		/// 太牛逼了这个判断---简直就是递归返回的一个绝佳点
		if(left!=null&&right!=null){
			return  root;
		}
		if(left!=null){
			return left;
		}else {
			return right;
		}
	}
}
