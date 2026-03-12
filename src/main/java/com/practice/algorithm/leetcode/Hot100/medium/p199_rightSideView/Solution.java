package com.practice.algorithm.leetcode.Hot100.medium.p199_rightSideView;

import com.practice.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;



/**
 * LeetCode 199. 右视图
 * 题目描述: 1.不是,正确率这么高吗,我要些不出来岂不是很......
 * 示例:
 * 解题思路:
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {


	public List<Integer> rightSideView(TreeNode root) {
        /** 不对--看清楚这个例子
         *  [1,null,2,null,5,4,6,3]
         *  //根右遍历--难点在于要记录深度吗,右子树?
		 //迭代能做吗?---我认为可以---两个循环--先右后左

		List<Integer> result=new ArrayList<>();
		if(root==null){
			return result;
		}

		TreeNode node=root;
		int flag=0;
		while (root!=null){
			result.add(root.val);
			flag++;
			if(root.right!=null){
				root=root.right;
			}else {
				root=root.left;
			}
		}
		root=node.left;
		flag-=1;
		while (root!=null){
			if(flag!=0){
				flag--;
				if(root.right!=null){
					root=root.right;
				}else {
					root=root.left;
				}
				continue;
			}
			result.add(root.val);
			if(root.right!=null){
				root=root.right;
			}else {
				root=root.left;
			}
		}
		return result;*/
	}
}
