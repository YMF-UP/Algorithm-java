package com.practice.algorithm.leetcode.Hot100.medium.p105_buildTree;

import com.practice.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode 105. 先序和中序确定
 * 题目描述:
 * 示例:
 * 解题思路:  1.说实话直接判断比较容易,但是写下来还真难啊
 *          2.思路很简单--但是实现很难啊
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {
//	private  int dex=0;
	//找匹配的
	/*private  int find(int[] inorder, int x){
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i]==x){
				return i;
			}
		}
		return 0;
	}*/
	public TreeNode buildTree(int[] preorder, int[] inorder) {
           //感觉也是递归构建--前序确定根,中序确定左右
		   //也就是需要传递下标吗?
		   //问题在于迭代我处理不了内层的,递归我处理不了位置
		/*int j=0;
		TreeNode root=new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			//找中序位置
			for ( ; i>j&&j < inorder.length; j++) {
				if(inorder[j]==preorder[i]){
					break;
				}
			}
			//已经找到了根在中序的位置--左右去处理--递归啊需要
			//再来个for确定
		}*/
		//1.通过先序遍历确定根节点--分左右
		//2.递归左右
		//3.返回节点

		/// 通过先序找根节点--左右子树继续去分
		/// 先左边吗？--先序确定左右子树
		/// 分数组---关键就是在当前分开的数组去进行操作---按下标吗？
		/// 1.找左右子树---2.继续递归
		HashMap<Integer,Integer> index=new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			index.put(inorder[i],i);
		}//如果碰到重复怎么办
		return reset(0,preorder.length-1,0,preorder,index);
	}
	/// 需要开始、结束;左右子树
	private  TreeNode reset(int start,int end,int intL,int []preorder, Map<Integer, Integer> index){
        ///通过哈希去找下标位置---也就是分割点--root点---怎么自增?
		if(start>end){
			return null;
		}
		TreeNode root=new TreeNode(preorder[start]);
		int leftSize=index.get(preorder[start])-intL;
		root.left=reset(start+1,start+leftSize,intL,preorder,index);
        root.right=reset(start+leftSize+1,end,leftSize+intL+1,preorder,index);
		return root;
	}
}
