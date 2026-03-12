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

	/*class Solution {
		private int k;

		public int kthSmallest(TreeNode root, int k) {
			this.k = k;
			return dfs(root);
		}

		private int dfs(TreeNode node) {
			if (node == null) {
				return -1; // 题目保证节点值非负，用 -1 表示没有找到
			}
			int leftRes = dfs(node.left);
			if (leftRes != -1) { // 答案在左子树中
				return leftRes;
			}
			if (--k == 0) { // 答案就是当前节点
				return node.val;
			}
			return dfs(node.right); // 右子树会返回答案或者 -1
		}
	}

	作者：灵茶山艾府
	链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2952810/zhong-xu-bian-li-pythonjavaccgojsrust-by-wc02/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
