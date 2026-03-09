package com.practice.algorithm.leetcode.Hot100.medium.p98_isValidBST;

import com.practice.algorithm.model.TreeNode;



/**
 * LeetCode 98. 判断搜索树
 * 题目描述:
 * 示例:
 * 解题思路:1.就是很简单的判定---中序遍历是否可行就行了
 *        2.问题在于怎么判断
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	/*private boolean dfs(TreeNode root,int val){
		if(root.left==null&&root.right==null){
			if(root.val>=val){
				return false;
			}else {
				return  true;
			}
		}
		boolean left=true,right=true;
		if(root.left!=null){
			 left=dfs(root.left,root.val);
		}
		if(root.right!=null){
		 right=dfs(root.right,root.val);
		}
		return left&&!right;

	}*/
	private boolean dfsLeft(TreeNode root,int val){
		if(root.left==null&&root.right==null){
			if(root.val>=val){
				return false;
			}else {
				return  true;
			}
		}
		boolean left=true,right=true;
		if(root.left!=null){
			left=dfsLeft(root.left,root.val);
		}
		if(root.right!=null){
			right=dfsRight(root.right,root.val);
		}
		return left&&right;
	}
	private boolean dfsRight(TreeNode root,int val){
		if(root.left==null&&root.right==null){
			if(root.val<=val){
				return false;
			}else {
				return  true;
			}
		}
		boolean left=true,right=true;
		if(root.left!=null){
			left=dfsLeft(root.left,root.val);
		}
		if(root.right!=null){
			right=dfsRight(root.right,root.val);
		}
		return left&&right;
	}


	public boolean isValidBST(TreeNode root) {
         //要依赖于前一个的中序遍历得到的数值

	}
}
