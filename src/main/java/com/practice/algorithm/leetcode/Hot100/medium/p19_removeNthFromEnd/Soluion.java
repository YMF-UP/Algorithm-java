package com.practice.algorithm.leetcode.Hot100.medium.p19_removeNthFromEnd;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 19. 删除倒置
 * 题目描述：
 * 示例：
 * 解题思路：1.我现在对链表还真没有什么感悟
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Soluion {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        // 坦白讲--两趟的话肯定简单--一趟的话我还真不知道怎么处理--还是对链表不熟悉
		// 明白了--还是快慢指针--就还是边界难处理了
        ListNode slow=head;
		ListNode fast=head;
		while (n!=0){
			fast=fast.next;
			n--;
		}
		//表明已经超过当前长度了
		if(fast==null){
           head=head.next;
		   return head;
		}
        while (fast.next!=null){
			fast=fast.next;
			slow=slow.next;
        }
			slow.next=slow.next.next;

		return head;
	}
}

