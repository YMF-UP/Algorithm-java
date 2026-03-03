package com.practice.algorithm.leetcode.Hot100.easy.p226_invertTree;

import com.practice.algorithm.model.TreeNode;

public class Solution {

	private  void reverse(TreeNode root){
          if(root==null){
			  return;
          }
		  reverse(root.left);
		  //交换--然后再反转root.left
		  TreeNode rNode=root.right;
		  root.right=root.left;
		  root.left=rNode;
		 reverse(root.left);
	}

	public TreeNode invertTree(TreeNode root) {
        //也是递归做---就是怎么说呢,递归都是可以抽象为不同的树
		//但是怎么感觉这个用栈来写更简单啊--都一样了,因为去做都是自底向上
        //中序遍历啊,好像--哈哈
		reverse(root);
		return  root;
	}

/*	class Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			}
			TreeNode left = invertTree(root.left); // 翻转左子树
			TreeNode right = invertTree(root.right); // 翻转右子树
			root.left = right; // 交换左右儿子
			root.right = left;
			return root;
		}
	}

	作者：灵茶山艾府
	链接：https://leetcode.cn/problems/invert-binary-tree/solutions/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
