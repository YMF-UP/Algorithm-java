package com.practice.algorithm.leetcode.Hot100.easy.p94_inorderTraversal;

import com.practice.algorithm.model.TreeNode;

import java.util.*;

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
//          orderPut(root,result);
		/// 迭代就是模拟栈--但是deep seek给了一种算法很有意思,变成线索树--Morris 遍历
		while (root!=null){
			//要写两个循环吗--毕竟放左和放右可不一样啊
			//算了还是看一下题解吧--还是没想明白
		}
		return result;
	}

	/**
	  // 0=白(未访问), 1=灰(已访问子树,该输出), 用Pair或两个栈或改节点(不推荐)
     // 实际面试常用: 两个栈,或一个栈+判断
	// 终极简洁版: 中序(最常用)
	public List<Integer> inorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> s = new ArrayDeque<>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {  // 一路向左
				s.push(root);
				root = root.left;
			}
			root = s.pop();         // 左到头,访问
			res.add(root.val);
			root = root.right;      // 转右
		}
		return res;
	}

	// 前序: 访问时机改在第一次入栈前
	public List<Integer> preorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> s = new ArrayDeque<>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				res.add(root.val);  // 先访问(根)
				s.push(root);
				root = root.left;   // 再左
			}
			root = s.pop().right;   // 转右
		}
		return res;
	}

	// 后序: 最难,用"根右左"入栈,最后reverse,或记录prev节点
	public List<Integer> postorder(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>(); // 头插或最后reverse
		Deque<TreeNode> s = new ArrayDeque<>();
		if (root != null) s.push(root);
		while (!s.isEmpty()) {
			root = s.pop();
			res.addFirst(root.val);  // 头插法: 根右左 → 左右根
			if (root.left != null) s.push(root.left);  // 先左
			if (root.right != null) s.push(root.right); // 后右(先出)
		}
		return res;
	}*/


}
