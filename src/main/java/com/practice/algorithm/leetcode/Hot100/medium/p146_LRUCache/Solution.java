package com.practice.algorithm.leetcode.Hot100.medium.p146_LRUCache;



import java.util.HashMap;

/**
 * LeetCode 146. LRU
 * 题目描述：
 * 示例：
 * 解题思路：1.可是我记得LRU是用栈实现的啊--我记混了,并不是了看来
 *         2.这个是用链表
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {


    //10:41
	//我看标签写的是哈希和双向链表
	class LRUCache {
	    private class Node{
		    public int key;
		    public int value;
		    public Node pre;
		    public Node next;
		    public Node(int key,int value){
			    this.key=key;
			    this.value=value;
		    };
		    public Node(){

		    };

	    }
        //LRU我记得挺有意思的--但是我记得是用栈来写啊
	    //没给链表定义，要重写吗?--但是能看出来吗?--不是用链表写吧
	    //LRU的本质就是替换--头插法就是,但是这个少了一点自动更新--就是只有put才能更新
	    HashMap<Integer,Node> cache=new HashMap();
	    Node dummy=new Node();
//	    Node dummyTail=new Node();
	    private final int cap;
		public LRUCache(int capacity) {
            //卡在了第一步--一开始是只给大小,怎么建立呢?只有put里面才能建立
			//先建立起来--随后就是put和get的实现了
			//pre如果都是dummyHead的话
			/** 不对这么写--太死板了
			 * Node pre=dummyHead;
			for (int i = 0; i < capacity; i++) {
				Node cur=new Node();
				cur.pre=dummyHead;
				cur.tail=dummyTail;
				pre.next=cur;
				pre=cur;
			}
			pre.next=dummyTail;
			dummyTail.pre=pre;//最后一个*/
			/// 只设了一个吗?
            cap=capacity;
			dummy.pre=dummy;
			dummy.next=dummy;
		}

		public int get(int key) {
           //要求o(1)就不能循环了啊--也就不能用链表了啊--哈希应该得用
		   //要更新了,访问的要放到最前面了
		   //但是哈希怎么做到顺序啊,就像链表怎么随取一样。
		   //放到最前面
			if(cache.get(key)!=null){
				Node exit=cache.get(key);
				remove(exit);
				add(exit);
				return exit.value;
			}
			return -1;
		}

		public void put(int key, int value) {
             /** 少考虑好几步
              * if(cache.getOrDefault(key,new Node())==null){
				 //要找最后一个的前置,直接替代--不是替代,而是踢出去,所以pre不能全指向前面Head,但是更新怎么放前面
	             Node pre=dummyTail.pre;
//               Node cur=new Node(key,value,dummyTail,)
             }*/
			/* 会重复放吗?--不会吧
			else {
				 //有的话就放在最前面

             }*/
			Node cur=new Node(key,value);
			if(cache.get(key)!=null){
				/// 放到最前面--然后踢出去
			    /// 好像不太对啊--无论是先踢出去还是先插进来好像都改变了pre和next--先踢走可以
			    Node in=cache.get(key);
				in.value=value;
			    remove(in);
				add(in);
			}else{
				///这个很重要--之前卡的有这一步
				if(cache.size()==cap){
					///踢出去最后的然后头插法
				    ///先插然后踢出去

				   /// 应该先踢出去再插进来
					Node last=dummy.pre;
					remove(last);
					cache.remove(last.key);

					/**
					/// 踢出去最后一个

				   /// 只有一个dummy的话怎么找最后一个--dummy的pre指向的就是最后一个,真是逻辑完备啊
				    Node last=dummy.pre;
					remove(last);
					cache.remove(last.key);
					 */
				}
				add(cur);
				cache.put(key,cur);
				/*///这个else多余了
				   else {
                    /// 还是头插法
					add(cur);
					cache.put(key,cur);
				}*/

			}

		}

	    private void remove(Node last) {
		    last.pre.next=last.next;
		    last.next.pre= last.pre;
	    }

	    private void add(Node cur) {
		    cur.next=dummy.next;
		    cur.pre=dummy;
		    dummy.next.pre=cur;
		    dummy.next=cur;
	    }
    }
}
