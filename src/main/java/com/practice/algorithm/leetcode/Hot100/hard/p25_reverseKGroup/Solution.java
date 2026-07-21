package com.practice.algorithm.leetcode.Hot100.hard.p25_reverseKGroup;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 25.
 * 题目描述：
 * 示例：
 * 解题思路：1.到还是和24差不多吗，对吧
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

//	public static ListNode reverseKGroup(ListNode head, int k) {
//        //这个是分组处理--本来是想到反转链表的---但是不确定k是否存在吧--或者说先判断?
//        //感觉就还是先判断然后反转--短于k的就不反转了
//		//有一点的逻辑思考啊--k范围内做转置--但是多两个点考虑:1.首位 2.跟随--也包括了返回值
//		ListNode dummy=new ListNode(0,head);
//		ListNode node=dummy;
//		int count=0;
//		while (count==0&&dummy.next!=null){
//			ListNode nodek=dummy;
//			count=k;
//			//一定要先判断是否在k以内吗?
//            while(count!=0&&nodek.next!=null){
//				nodek=nodek.next;
//				count--;
//            }
//			ListNode next=nodek.next;
//			ListNode node1=dummy.next;
//			ListNode node2=node1.next;
//			if(node2==null){
//				break;
//			}
//			ListNode node3;
//			// 提前处理一下首尾吗?--不提前会怎么样
//			if (count==0){
//				node1.next=next;
//				dummy.next=nodek;
//				dummy=node1;
//			}
//			//开始反转
//			while (count==0&&node2!=next){
//				node3=node2.next;
//			    node2.next=node1;
//			    node1=node2;
//			    node2=node3;
//			}
//		}
//		return node.next;
//	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		//还真是手生了啊,完全就很困惑了,感觉很简单
		//第一步--判断能不能有k个;第二步就是开始翻转就行了
		int count=0;
		ListNode dummy=new ListNode(0,head);
		ListNode p=dummy;
		ListNode cur=dummy;
		while (cur!=null){
			count=0;
			//这个就不对了,因为成功后的下一次一定能够整除k
			while (cur!=null&&count!=k){
			cur=cur.next;
			count++;
		    }
		  if(count%k!=0){
			break;
		   }
		  //问题是第一个需要把dummy的next给处理了啊,怎么处理
		  //要进行一次初始化--还缺一个初始的
          ListNode pre=p.next;//从这个开始翻转啊
		  p.next=cur;
		  p=cur;
		  //开始翻转
		  while (count!=0&&pre.next!=null){
			  ListNode  node2=pre.next;
			  ListNode node3=node2.next;
			  node2.next=pre;
			  pre=node3;
		  }

	   }
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode node=reverseKGroup(head,2);
	}
}
