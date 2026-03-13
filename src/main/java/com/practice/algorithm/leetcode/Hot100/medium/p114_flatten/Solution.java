package com.practice.algorithm.leetcode.Hot100.medium.p114_flatten;

import com.practice.algorithm.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * LeetCode 114. 改链表
 * 题目描述:
 * 示例:
 * 解题思路:
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {

	public void flatten(TreeNode root) {
		//迭代还是递归呢?
		//因为是要求和先序遍历顺序一样--右为后,左为null
		//迭代得用栈记录--也需要额外的空间,除非每次都把右子树搬过去
       TreeNode cur=root;
	  /* while (cur!=null){
             if(cur.right!=null){
				 while ()
             }
	   }*/
		//先用栈写一个吧
		if(root==null){
			return;
		}
		Deque<TreeNode> deque=new ArrayDeque<>();
		Deque<TreeNode> stack=new ArrayDeque<>();
		while (cur!=null||!stack.isEmpty()){
			while (cur!=null){
				stack.push(cur);
				deque.add(cur);
				cur=cur.left;
			}
			cur=stack.pop().right;
		}
		while (!deque.isEmpty()){
			TreeNode node=deque.poll();
			root.right=node;
			root.left=null;
			root=root.right;
		}
		root.right=null;
	}
}
