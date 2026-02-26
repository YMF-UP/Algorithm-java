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
}
