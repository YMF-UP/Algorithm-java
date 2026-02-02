package com.practice.algorithm.leetcode.Hot100.medium.p142_detectCycle;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 142. 节点
 * 题目描述：
 * 示例：
 * 解题思路：1.说实话这个我是真有点看不懂一开始--因为我一开始以为肯定在入口处相遇
 *         2.但其实不是---就没有绕过来这个弯
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {
	public ListNode detectCycle(ListNode head) {
        //不看题解还真不知道是这么个意思--既然看了那就先写一下
		// 主要还是一个数学公式推导
		ListNode slow=head;
		ListNode fast=head;
		while (fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				//相遇了---但不是入环点
				// 纯数学推导---(kc-a)+a
				while (slow!=head){
					head=head.next;
					slow=slow.next;
				}
				return head;
			}
		}
		return null;
	}
}
