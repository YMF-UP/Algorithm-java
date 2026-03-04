package com.practice.algorithm.leetcode.Hot100.easy.p543_diameterOfBinaryTree;

import com.practice.algorithm.model.TreeNode;

public class Solution {
   /* private int deep(TreeNode root){
          if(root==null){
			  return 0;
          }
		  return Math.max(deep(root.left),deep(root.right))+1;
    }*/
    private int maxDiameter = 0; /// 这就是那个全公司共享的计分板
	private int twoAll(TreeNode root){
		//不对--应该自底向上--然后判断大小
		//感觉就差了一点--不是每一个都走一遍--一遍走上去,一遍判断是否是最大的?
	/*	if()
		int lLen=twoAll(left.left,left.right,max);
		int rLen=twoAll(right.left,right.left,max);
		*//*int lenLeft=deep(left);
		int lenRight=deep(right);*/
		if(root==null){
			return 0;
		}
		//左右的深度
		int lLen=twoAll(root.left);
        int rLen=twoAll(root.right);
		/// 返回的应该是当前节点左右深度之和并且和之前的对比--max
		if(lLen+rLen>maxDiameter){
			maxDiameter=rLen+lLen;
		}
        return Math.max(lLen,rLen)+1;
	}
	public int diameterOfBinaryTree(TreeNode root) {
           //噶比,哈哈哈,怎么打出这个了,留着吧,当作纪念
		   //感觉像是深度的的一个变种--就是更简单一些,直接就是左深度加上右深度
		  /// 忘了一个关键点了--就是最长的不一定经过根---也就是每一个都要判断了--要加到递归里面不然太复杂了
		  /// 现在的问题就是如何在中间就判断
		 int max=0;
		 int len=twoAll(root);
		 return  maxDiameter;
	}
}
