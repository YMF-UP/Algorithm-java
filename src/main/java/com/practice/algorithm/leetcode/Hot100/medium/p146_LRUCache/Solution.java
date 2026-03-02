package com.practice.algorithm.leetcode.Hot100.medium.p146_LRUCache;


import java.util.HashMap;

/**
 * LeetCode 146. LRU
 * 题目描述：
 * 示例：
 * 解题思路：1.可是我记得LRU是用栈实现的啊
 *         2.这个是用链表
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

	public class Node{
		public int key;
		public int value;
		public Node pre;
		public Node tail;
		public Node next;
		public Node(){};
		public Node(int key,int value,Node pre,Node next,Node tail){
			this.key=key;
			this.value=value;
			this.pre=pre;
			this.next=next;
			this.tail=tail;
		};
	}
    //10:41
	//我看标签写的是哈希和双向链表
	class LRUCache {
        //LRU我记得挺有意思的--但是我记得是用栈来写啊
	    //没给链表定义，要重写吗?--但是能看出来吗?--不是用链表写吧
	    //LRU的本质就是替换--头插法就是,但是这个少了一点自动更新--就是只有put才能更新
	    HashMap<Integer,Node> cache=new HashMap();
		Node dummyHead=new Node();
		Node dummyTail=new Node();
		public LRUCache(int capacity) {
            //卡在了第一步--一开始是只给大小,怎么建立呢?只有put里面才能建立
			//先建立起来--随后就是put和get的实现了
			//pre如果都是dummyHead的话
			Node pre=dummyHead;
			for (int i = 0; i < capacity; i++) {
				Node cur=new Node();
				cur.pre=dummyHead;
				cur.tail=dummyTail;
				pre.next=cur;
				pre=cur;
			}
			pre.next=dummyTail;
			dummyTail.pre=pre;//最后一个
		}

		public int get(int key) {
           //要求o(1)就不能循环了啊--也就不能用链表了啊--哈希应该得用
		   //要更新了,访问的要放到最前面了
		   //但是哈希怎么做到顺序啊,就像链表怎么随取一样。
		   //放到最前面
		}

		public void put(int key, int value) {
             if(cache.getOrDefault(key,new Node())==null){
				 //要找最后一个的前置,直接替代--不是替代,而是踢出去,所以pre不能全指向前面Head,但是更新怎么放前面
	             Node pre=dummyTail.pre;
                 Node cur=new Node(key,value,dummyTail,)
             }
			/* 会重复放吗?--不会吧
			else {
				 //有的话就放在最前面

             }*/
		}
	}
}
