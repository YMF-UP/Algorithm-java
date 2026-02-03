package com.practice.algorithm.leetcode.Hot100.medium.p2_addTwoNumbers;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 2. 链表之和
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //坦白讲--我真想不到什么高明的解法--只有暴力莽撞了
		//头插法
		//或者转换成字符串是否可行---怎么相加呢,因为肯定不可能是整数的相加了,进位对于字符来讲不能处理吧---但最终也要转成节点,这个确实是个问题
		ListNode dummy=new ListNode();
		ListNode cur=dummy;
		int flag=0;
		int val=0;
		int sum=0;
		//一长和一短
		while (l1!=null||l2!=null){
			if(l1!=null&&l2!=null){
			 sum=l1.val+ l2.val;
				l1=l1.next;
				l2=l2.next;
			} else if (l1!=null) {
				sum= l1.val;
				l1=l1.next;
			}else {
				sum=l2.val;
				l2=l2.next;
			}
			val=(sum+flag)%10;
			flag=(sum+flag)/10;
			ListNode newNode=new ListNode(val,null);
			cur.next=newNode;
			cur=newNode;
		}
		if(flag==1){
			ListNode newNode=new ListNode(1,null);
			cur.next=newNode;
		}
      /* while (l1!=null){
	        m=l1.val;
	       val=(m+flag)%9;
	       flag=(m+flag)/9;
	       ListNode newNode=new ListNode(val,null);
	       cur.next=newNode;
	       cur=newNode;
       }
       while (l2!=null){
	        m=l2.val;
	       val=(m+flag)%9;
	       flag=(m+flag)/9;
	       ListNode newNode=new ListNode(val,null);
	       cur.next=newNode;
	       cur=newNode;
       }*/
       return dummy.next;
	}

}
