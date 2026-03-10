package com.practice.algorithm.leetcode.Hot100.medium.p98_isValidBST;

import com.practice.algorithm.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


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
	/*private boolean dfsLeft(TreeNode root,int val){
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
	}*/
	private long pre= Long.MIN_VALUE;
	private boolean dfs(TreeNode root){
		//1.怎么判断终止条件,怎么返回?
		if(root==null){
			return true;
		}
		//2.应该是要在进入右子树前开始判断--但是刚开始pre是不存在具体值的

		boolean leftFlag=dfs(root.left);
		if(pre>=root.val){
			return false;
		}
         pre=root.val;
		boolean rightFlag=dfs(root.right);
		return leftFlag&&rightFlag;
	}

	public boolean isValidBST(TreeNode root) {
         //要依赖于前一个的中序遍历得到的数值
		Deque<TreeNode> stack=new ArrayDeque<>();//栈
		//栈的中序遍历
		long flag=Long.MIN_VALUE;
		boolean is=true;
		while (root!=null||!stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}else {
				root=stack.pop();
				if(flag>=root.val){
					return false;
				}
				flag=root.val;
				root=root.right;
			}
		}
		return  is;
//        return dfs(root);



	}
}
