package com.practice.algorithm.leetcode.Hot100.hard.p23_mergeKLists;

import com.practice.algorithm.model.ListNode;


/**
 * LeetCode 23. k个链表合并
 * 题目描述：1.感觉像是plus的归并
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

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

	public ListNode mergeKLists(ListNode[] lists) {
        // 从描述来看就是要归并啊--难点在哪里?
		// 如果只是单纯的归并--值得标hard吗?
		// 难点:至少我目前想了一下不好处理的几个点
		// 1.多个list也就是数组--怎么存,存在哪里,毕竟给的是一个链表数组
		// 2.一步一步的归并但最终要给出一个listnode类型--也就是要合并在一个里面
		// 对于以上问题感觉可以都放在第一个链表里面,其余被归并的都置为空
		// 还有一个办法就是每次归并都创建一个新的lists--这个感觉简单一些,就是复杂度
		if (lists == null || lists.length == 0)
			return null;
		while (lists.length!=1){
            ListNode[] cur=new ListNode[(lists.length+1)/2];
		    int i=0,j=0;
			for ( i = 0; i < lists.length-1; i+=2) {
				ListNode now=merge(lists[i],lists[i+1]);
				cur[j++]=now;
			}
			if(i<lists.length){
				cur[j]=lists[i];
			}
			lists=cur;
		}
		/// 感觉可以用递归来做---但是要写新函数了--毕竟要传当前的归并起点下标
        return lists[0];
	}






	/*class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0) return null;
			return mergeK(lists, 0, lists.length - 1); // 初始下发任务：0 到 末尾
		}

		// 【核心分治函数】
		private ListNode mergeK(ListNode[] lists, int left, int right) {
			// 1. Base Case (终止条件：只剩一个抽屉)
			if (left == right) {
				return lists[left]; // 直接原样返回仓库里的东西，不用存！
			}

			// 2. Recursive Step (找中点，分派给两个下属)
			int mid = left + (right - left) / 2; // 防溢出的标准写法
			ListNode l1 = mergeK(lists, left, mid);      // 下属A去拿左边的结果
			ListNode l2 = mergeK(lists, mid + 1, right); // 下属B去拿右边的结果

			// 3. Logic (汇总：把下属拿回来的两条链表合并)
			return merge(l1, l2); // 这里的 merge 就是力扣 21 题（合并两个有序链表）
		}

		// 这个是你早就写对的黑盒，一字不改
		private ListNode merge(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0);
			ListNode cur = dummy;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
				cur = cur.next;
			}
			cur.next = (l1 != null) ? l1 : l2;
			return dummy.next;
		}
	}*/
}
