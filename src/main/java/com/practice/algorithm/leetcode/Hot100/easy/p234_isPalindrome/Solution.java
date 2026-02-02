package com.practice.algorithm.leetcode.Hot100.easy.p234_isPalindrome;



/**
 * LeetCode 234. 回文
 * 题目描述：
 * 示例：
 * 解题思路： 1.最简单就是空间换时间了--暴力
 *          2.但是要常数时间复杂度的话--原地判断--那要怎么办?--取中间--然后让后半段倒置--然后再一同寻找,判断即可
 *          3.中间位置就是走一步和走两步这样---这个确实有边界情况要考虑
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
	public static boolean isPalindrome(ListNode head) {
        ListNode pre=head;
		ListNode end=head;
		//先走两步--再走一步
		while (end.next!=null){
			end=end.next.next;
			if(end==null){
				break;
			}
			pre=pre.next;
		}
        //从medium开始倒转--但是有一个边界就是两个或者一个的时候--这个确实有点难搞啊
		ListNode cur=pre.next;
		ListNode tail=null;
		pre.next=null;
		while (cur!=null){
			ListNode next=cur.next;
			cur.next=tail;
			tail=cur;
			cur=next;
		}

		//pre作为尾巴
		while (tail!=null&&head!=null){
			if(tail.val!=head.val){
				return false;
			}
			tail=tail.next;
			head=head.next;
		}
		return true;
	}

	public static void main(String[] args) {


	}
}
