package com.practice.algorithm.leetcode.Hot100.easy.p21_mergeTwoLists;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 21. 算是合并
 * 题目描述：
 * 示例：
 * 解题思路：1.就像归并一样
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		  //倒是比数组的归并好处理一点--这个只需注重一个表即可--所以其实还是创建新表方便
          /* 还是太复杂--不如创建新表
           while (list1!=null){
			   if (list1.val<=list2.val){
                   if(list1.next!=null&&list1.next.val>=list2.val){
                         ListNode stash=list2.next;
						 list2.next=list1.next;
						 list1.next=list2;
						 list2=stash;
                   }
				   list1=list1.next;
			   }else {
				   ListNode status=list2;
				   while (list2!=null&&list2.next.val>list1.val){

				   }
			   }

           }*/
		/*if(list1==null){
			return list2;
		} else if (list2 == null) {
			return list1;
		}*/
		ListNode newNode=new ListNode();
		/*if(list1.val>=list2.val){
			newNode=list2;
			list2=list2.next;
		}else {
			newNode=list1;
			list1=list1.next;
		}*/
		ListNode now=newNode;
		newNode.next=null;
		while (list1!=null&&list2!=null){
			if(list1.val>=list2.val){
				ListNode status=list2;

				newNode.next=status;
				list2=list2.next;
			}else {
				ListNode status=list1;

				newNode.next=status;
				list1=list1.next;
			}
			newNode=newNode.next;
			newNode.next=null;
		}
		if(list1==null&&list2!=null){
			newNode.next=list2;
		} else if (list2 == null && list1 != null) {
			newNode.next=list1;
		}
		return  now;
	}
}
