package com.practice.algorithm.leetcode.Hot100.easy.p94_inorderTraversal;

import com.practice.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 94.中序遍历
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

/// 梦回大学啊
public class Solutin {
	private void orderPut(TreeNode now,List<Integer> result){
		if(now!=null){
		   orderPut(now.left,result);
		   result.add(now.val);
		   orderPut(now.right,result);
		}
	}
	public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> result=new ArrayList<>();
          orderPut(root,result);
		  return result;
	}
}
