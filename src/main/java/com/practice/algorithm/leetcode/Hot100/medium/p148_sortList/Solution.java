package com.practice.algorithm.leetcode.Hot100.medium.p148_sortList;

import com.practice.algorithm.model.ListNode;

import java.util.List;

/**
 * LeetCode 148.链表排序
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

public class Solution {

	private ListNode medium(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
		while (fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	private ListNode merge(ListNode list1,ListNode list2){
		/// 之前没怎么仔细看题解--虽然自己也写出来了--但终究不是最优解
		ListNode dummy=new ListNode(0,null);
		ListNode cur=dummy;
			while(list1!=null&&list2!=null){
				if(list1.val<list2.val){
					dummy.next=list1;
					list1=list1.next;
				}else {
					dummy.next=list2;
					list2=list2.next;
				}
				dummy=dummy.next;
			}
			 if (list1!=null) {
				dummy.next=list1;
			 }
			 else {
                dummy.next=list2;
			 }

		return cur.next;
	}

	/* 并不对的快排--至少对这个题来说--或者说链表不能用快排
	private ListNode quickSort(ListNode head){


		return head;
	}*/
	public ListNode sortList(ListNode head) {
		/*if(head==null||head.next==null){
			return head;
		}
        ListNode dummy=head;
        //排序倒是好排--但是怎么说呢--进阶:你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
		//如果只排序val,那似乎很简单--但是也无法保证常数个空间
		//关键就在于排序--O(n log n)对应的排序算法:二分、快排都不行,堆排序好像也是啊
		//我怎么感觉快排思想可以啊--就是感觉不太好实现--标准解法会是什么呢?我目前确实只看到这个了
		//链表的话需要在中间开始排序--快慢指针--但是每一次都要找
		//不像数组容易判定终止条件--对于链表:前面部分需要传中间位置,后半部分null终止就可以
		//左右需要写两个不一样的函数排序--不能通用因为
		//但是好像很难递归
		ListNode  middle=medium(head);//找中间位置
		return dummy;*/
		/// 归并算法处理链表的排序--或者说归并处理的就是链表
		/// 题解分了迭代和递归---我还真有点懵--而且我看题解还挺长的
		/// 递归好像更好理解一些---一直分两段直到只剩一个--返回后怎么做(这个就是我困扰的点)
		/// 一层左一层右--像二叉树一样--先走左,后返回到父节点走右--感觉像是简单的中序遍历啊
		if(head==null||head.next==null){
			return head;
		}
		ListNode middle=medium(head);//也可以称之为父节点了
        ListNode right=sortList(middle.next);
		middle.next=null;
        ListNode left=sortList(head);
		/// 然后开始合并--从1个数开始也就是返回到父节点--就是返回这个有点不太懂怎么处理,还是逻辑问题吗?
		return merge(left,right);
	}
}
