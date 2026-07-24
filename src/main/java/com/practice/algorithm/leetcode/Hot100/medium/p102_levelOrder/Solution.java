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

//	public List<List<Integer>> levelOrder(TreeNode root) {
//		if(root==null)
//		{
//			return List.of();
//		}
//		List<List<Integer>> order=new ArrayList<>();
//		Queue<TreeNode> queue=new LinkedList<>();
//		queue.add(root);
//		//其实就是bfs
//		while (!queue.isEmpty()){
//            //现在的难点就是在于判断是不是在同一层--能插null的
//			int size=queue.size();
//			List<Integer> level=new ArrayList<>(size);
//			while (size-->0) {
//				root=queue.poll();
//                if(root.left!=null)
//				{
//			    queue.add(root.left);}
//				if(root.right!=null)
//				{
//				queue.add(root.right);}
//				level.add(root.val);
//
//			}
//			order.add(level);
//		}
//		return  order;
//	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		//就是一个模板题啊,但是我还真不一定能一次写出来

		List<List<Integer>> ans=new ArrayList<>();
		Deque<TreeNode> deque=new ArrayDeque<>();
		if(root==null){
			return ans;
		}
		//这个要先填入吗?
		deque.addFirst(root);
		while (!deque.isEmpty()){
			int num=deque.size();
			List<Integer> path=new ArrayList<>();
			for (int i = 0; i < num; i++) {
				TreeNode cur=deque.pop();
				path.add(cur.val);
				if(cur.left!=null){
					deque.add(cur.left);
				}
				if(cur.right!=null){
					deque.add(cur.right);
				}
			}
			ans.add(new ArrayList<>(path));
		}
        return ans;
	}
}
