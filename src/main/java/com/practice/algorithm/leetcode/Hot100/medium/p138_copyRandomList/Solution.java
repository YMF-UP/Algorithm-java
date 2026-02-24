package com.practice.algorithm.leetcode.Hot100.medium.p138_copyRandomList;

import java.util.HashMap;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}


public class Solution {
	public Node copyRandomList(Node head) {
      //循环得了--每就建立--反正本身也是依赖next向下走--不过要是超出的话,当前next
	  //所以先建立出val next 的,再后续一个循环处理random--一个循环能解决吗?--好像不行
      //不行--还有一个问题就是寻找到对应的那个--就还是循环--不然呢--哈希可以吗?
	  //最笨就是循环啊,每次都找
		Node cur=new Node(head.val);
		Node dummy=cur;
		HashMap<Integer,Node> index=new HashMap<>();
		for (;head!=null;head=head.next){
			 if(index.getOrDefault(head.val,new Node(head.val))==null){
                 //不存在的话就建立一个
				Node  deepRandom=new Node(head.random.val);
				index.put(head.random.val,deepRandom);
				cur.random=deepRandom;
				//感觉可以递归去做啊--不太行吧--没有终止条件啊
			 }
		}
		return dummy;
	}
}
