package com.practice.algorithm.leetcode.Hot100.easy.p101_isSymmetric;

import com.practice.algorithm.model.TreeNode;


/**
 * LeetCode 101. 轴对称
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

public class Solution {

//	private boolean  is(TreeNode left,TreeNode right){
//		if(left==null&&right==null){
//			return true;
//		}
//		if(left==null||right==null||left.val!=right.val){
//			return false;
//		}
//		//关键是两个都要判定---那怎么return呢?--或者说,判定终止条件
//		boolean isLeft= is(left.left,right.right);
//		boolean isRight=is(left.right,right.left);
//		return (isRight&&isLeft);
//	}
//
//	public boolean isSymmetric(TreeNode root) {
//        //有意思啊--递归和迭代
//		//得传两个root节点吧--当前层--层序遍历吗?--哈哈哈
//		return is(root.left,root.right);
//	}

	private  static boolean  test(TreeNode left,TreeNode right){
		if(left==null||right==null){
			return left==right;
		}
		if(left.val!=right.val){
			return false;
		}
		boolean isL=test(left.left,right.right);
		boolean isR=test(left.right,right.left);
        //返回还有点问题啊,不能这么返回的啊
		return isL&&isR;
	}
	public boolean isSymmetric(TreeNode root) {
		//说实话我对之前写的一点点印象都没有了
		return   test(root.left,root.right);
	}

}
