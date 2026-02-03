package com.practice.algorithm.leetcode.Hot100.easy.p21_mergeTwoLists;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 21. 算是合并
 * 题目描述：
 * 示例：
 * 解题思路：1.就像归并一样
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 *
 * 还是要多学习一下递归啊
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


		/*class Solution {
			public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
				ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
				ListNode cur = dummy; // cur 指向新链表的末尾
				while (list1 != null && list2 != null) {
					if (list1.val < list2.val) {
						cur.next = list1; // 把 list1 加到新链表中
						list1 = list1.next;
					} else { // 注：相等的情况加哪个节点都是可以的
						cur.next = list2; // 把 list2 加到新链表中
						list2 = list2.next;
					}
					cur = cur.next;
				}
				cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
				return dummy.next;
			}
		}

		作者：灵茶山艾府
		链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2373691/liang-chong-fang-fa-die-dai-di-gui-pytho-wf75/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


		/*class Solution {
			public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
				if (list1 == null) return list2; // 注：如果都为空则返回空
				if (list2 == null) return list1;
				if (list1.val < list2.val) {
					list1.next = mergeTwoLists(list1.next, list2);
					return list1;
				}
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}

		作者：灵茶山艾府
		链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2373691/liang-chong-fang-fa-die-dai-di-gui-pytho-wf75/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

	}
}
