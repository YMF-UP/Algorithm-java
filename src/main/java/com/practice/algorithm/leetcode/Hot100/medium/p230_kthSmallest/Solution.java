package com.practice.algorithm.leetcode.Hot100.medium.p230_kthSmallest;

import com.practice.algorithm.model.TreeNode;

public class Solution {
	private int count=0;
	private int result=0;
	/*private int dfs(TreeNode root,int k){
		if(root==null){
			return count+1;
		}
		int flagLeft=dfs(root.left,k);
		int flagRight;
		if(root.right!=null)
		{
		 flagRight=dfs(root.right,k);
		}
		return root.val;

	}*/
    private void dfs(TreeNode root,int k){
		if(root==null){
			return;
		}
		dfs(root.left,k);
		count++;
		if(count==k){
			result=root.val;
		}
		dfs(root.right,k);
    }
	public int kthSmallest(TreeNode root, int k) {
        //同样也是中序遍历--毕竟是顺序查找
//		return dfs(root,k);
		dfs(root,k);
		return  result;
	}

}
