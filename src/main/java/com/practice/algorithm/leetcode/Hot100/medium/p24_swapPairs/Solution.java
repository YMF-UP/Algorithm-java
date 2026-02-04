package com.practice.algorithm.leetcode.Hot100.medium.p24_swapPairs;

import com.practice.algorithm.model.ListNode;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		//乍一看也不像多难的啊--先写写试试
		ListNode left=head;
		ListNode right=head;
		ListNode dummy=new ListNode(0,head);
		ListNode now=dummy;
		while (right!=null&&right.next!=null){
			/*left=right;
			right=dummy;*/
			//上面的不对--这样无法交换--应该是next交换

			/*right=right.next;
			left.next=right.next;
			right.next=left;
			right=left.next;
			left=left.next;*/
			//也不对
			right=right.next;
			dummy.next=right;
			left.next=right.next;
			right.next=left;
			dummy=left;
			left=dummy.next;
			right=dummy.next;
		}

		return now.next;
	}

}
