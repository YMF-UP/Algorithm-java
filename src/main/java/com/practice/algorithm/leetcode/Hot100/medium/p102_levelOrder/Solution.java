package com.practice.algorithm.leetcode.Hot100.medium.p102_levelOrder;

import com.practice.algorithm.model.TreeNode;

import java.util.*;


/**
 * LeetCode 102. 层序遍历
 * 题目描述:
 * 示例:
 * 解题思路:1.这个就是队来写啊--bfs算是了
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> order=new ArrayList<>();

		Queue<TreeNode> queue=new LinkedList<>();
//		now.add(root);
		//其实就是bfs
		while (root!=null||!queue.isEmpty()){
            //现在的难点就是在于判断是不是在同一层--能插null的
			List<Integer> level=new ArrayList<>();
//			root=now.poll();
			while (root!=null) {

			    queue.add(root.left);
				queue.add(root.right);
				level.add(root.val);
				root=queue.poll();
			}
			order.add(level);

		}
		return  order;
	}
}
