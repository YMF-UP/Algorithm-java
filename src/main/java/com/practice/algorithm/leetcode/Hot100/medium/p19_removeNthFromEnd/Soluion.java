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

		/*class Solution {
			public ListNode removeNthFromEnd(ListNode head, int n) {
				// 由于可能会删除链表头部，用哨兵节点简化代码
				ListNode dummy = new ListNode(0, head);
				ListNode left = dummy;
				ListNode right = dummy;
				while (n-- > 0) {
					right = right.next; // 右指针先向右走 n 步
				}
				while (right.next != null) {
					left = left.next;
					right = right.next; // 左右指针一起走
				}
				left.next = left.next.next; // 左指针的下一个节点就是倒数第 n 个节点
				return dummy.next;
			}
		}

		作者：灵茶山艾府
		链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/2004057/ru-he-shan-chu-jie-dian-liu-fen-zhong-ga-xpfs/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
	}
}

