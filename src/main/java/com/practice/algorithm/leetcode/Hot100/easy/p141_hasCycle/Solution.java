package com.practice.algorithm.leetcode.Hot100.easy.p141_hasCycle;



/**
 * LeetCode 141. 环形
 * 题目描述：
 * 示例：
 * 解题思路：1.又让我想到了408里面的了
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {
	  public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
	public boolean hasCycle(ListNode head) {
          // 快和慢---相遇
		  ListNode slow=head;
		  ListNode fast=head;
		  while (fast!=null&&fast.next!=null){
			  slow=slow.next;
			  fast=fast.next.next;
			  if(slow==fast){
				  return true;
			  }
		  }
		  return false;
	}
}
