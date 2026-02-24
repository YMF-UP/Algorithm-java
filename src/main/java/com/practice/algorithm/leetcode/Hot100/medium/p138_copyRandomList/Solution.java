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
     /*
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
		*/

		//看来还是要两次循环吗?---倒也不是,和循环没关系,random要指向的是Node类型的节点啊--也就是说再遍历,不对
		//用哈希吗--存当前拷贝列表下的节点--就和上次的思路一样了--就还是没有一个完整的思路,就是第一步、第二步这种
		//目前是想到一个两次循环解法--第一次循环就是创建节点和next以及哈希存储,第二次循环就是处理random
	    //现在的关键就是哈希怎么存---key和value--明白了,因为是index,所以就减小了难度--不对啊,就是node啊,也不是index
		//如果给的不是index呢?而是node类型呢？又该如何做呢?
		//就是卡在了random这个指向怎么找--原来的链表指向的是node,我要的是新的指向新的node
		//哈希就存node node--key是旧node,value是新node
		if(head==null){
			return null;
		}
		Node dummy=head;
		Node cur=new Node(head.val);
        Node copy=cur;

		HashMap<Node,Node> map=new HashMap<>();
		map.put(head,cur);
		while (head.next!=null){
			head=head.next;
			Node then=new Node(head.val);
			cur.next=then;
			cur=then;
			map.put(head,cur);
		}
		cur.next=null;
		Node now=copy;
        while (dummy!=null){
			if(dummy.random!=null){
				copy.random=map.get(dummy.random);
			}
			else {
				copy.random=null;
			}
			copy=copy.next;
			dummy=dummy.next;
        }
		return now;
	}
}
