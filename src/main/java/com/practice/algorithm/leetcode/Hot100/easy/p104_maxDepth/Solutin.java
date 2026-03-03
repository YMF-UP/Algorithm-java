package com.practice.algorithm.leetcode.Hot100.easy.p104_maxDepth;

import com.practice.algorithm.model.TreeNode;

public class Solutin {

	private int deep(TreeNode root,int len){
		   if(root==null){
			   return len;
		   }
		return Math.max(deep(root.left,len+1),deep(root.right,len+1));
	}

	public int maxDepth(TreeNode root) {
          //这个是很简洁的,我记得,但是我只是记住了而已
		 int len=deep(root,0);
		 return len;
	}

	/*class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int lDepth = maxDepth(root.left);
			int rDepth = maxDepth(root.right);
			return Math.max(lDepth, rDepth) + 1;
		}
	}

	作者：灵茶山艾府
	链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/2010612/kan-wan-zhe-ge-shi-pin-rang-ni-dui-di-gu-44uz/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

	/*class Solution {
		private int ans;

		public int maxDepth(TreeNode root) {
			dfs(root, 0);
			return ans;
		}

		private void dfs(TreeNode node, int depth) {
			if (node == null) {
				return;
			}
			depth++;
			ans = Math.max(ans, depth);
			dfs(node.left, depth);
			dfs(node.right, depth);
		}
	}

	作者：灵茶山艾府
	链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/2010612/kan-wan-zhe-ge-shi-pin-rang-ni-dui-di-gu-44uz/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
