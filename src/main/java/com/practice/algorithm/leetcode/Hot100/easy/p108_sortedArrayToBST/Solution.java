package com.practice.algorithm.leetcode.Hot100.easy.p108_sortedArrayToBST;


import com.practice.algorithm.model.TreeNode;



/**
 * LeetCode 108. 平衡二叉树
 * 题目描述:
 * 示例:
 * 解题思路: 1.我记得平衡二叉树不好写啊,要旋转什么的
 *         2.但这个是升序数组更改,会好写点儿吗?
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {

	 private TreeNode midTo(int[] nums,int left,int right){
            /*  if(left>right){
				  return null;
              }
		 int mid=left+(right-left)/2;

		 root.left=midTo(root,left,mid-1);//左子树
		 root.right=midTo(root,mid+1,right);//右子树
		 return root;*/
		 if(left==right){
			 return null;
		 }
		 int mid=left+(right-left)/2;
		 TreeNode node=new TreeNode(nums[mid]);
		 node.left=midTo(nums, left,mid);//左子树
		 node.right=midTo(nums,mid+1,right);//右子树
		 return node;
	 }

	public TreeNode sortedArrayToBST(int[] nums) {
	/*	int left=0,right=nums.length-1;
		int mid=left+(right-left)/2;
		TreeNode root=new TreeNode(nums[mid]);
         //升序或者降序都好写,因为误差不超过一个,也就是不超过平衡二叉树的定义
         //但是我看要求是同一边--这个就不好处理了--因为不一样啊顺序--需要一开始决定好root
	     //这是个递归--因为需要一直找中间节点---root的左右其实都是分开的中间节点
		root.left=midTo(nums, left,mid-1);//左子树
        root.right=midTo(nums,mid+1,right);//右子树
		return root;*/
		return midTo(nums,0,nums.length);
	}
}
