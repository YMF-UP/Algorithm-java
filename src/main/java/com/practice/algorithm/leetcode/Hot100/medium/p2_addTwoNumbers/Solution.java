package com.practice.algorithm.leetcode.Hot100.medium.p2_addTwoNumbers;

import com.practice.algorithm.model.ListNode;



/**
 * LeetCode 2. 链表之和
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //坦白讲--我真想不到什么高明的解法--只有暴力莽撞了
//		//头插法
//		//或者转换成字符串是否可行---怎么相加呢,因为肯定不可能是整数的相加了,进位对于字符来讲不能处理吧---但最终也要转成节点,这个确实是个问题
//		ListNode dummy=new ListNode();
//		ListNode cur=dummy;
//		int flag=0;
//		int val=0;
//		int sum=0;
//		//一长和一短
//		while (l1!=null||l2!=null){
//			if(l1!=null&&l2!=null){
//			 sum=l1.val+ l2.val;
//				l1=l1.next;
//				l2=l2.next;
//			} else if (l1!=null) {
//				sum= l1.val;
//				l1=l1.next;
//			}else {
//				sum=l2.val;
//				l2=l2.next;
//			}
//			val=(sum+flag)%10;
//			flag=(sum+flag)/10;
//			ListNode newNode=new ListNode(val,null);
//			cur.next=newNode;
//			cur=newNode;
//		}
//		if(flag==1){
//			ListNode newNode=new ListNode(1,null);
//			cur.next=newNode;
//		}
//      /* while (l1!=null){
//	        m=l1.val;
//	       val=(m+flag)%9;
//	       flag=(m+flag)/9;
//	       ListNode newNode=new ListNode(val,null);
//	       cur.next=newNode;
//	       cur=newNode;
//       }
//       while (l2!=null){
//	        m=l2.val;
//	       val=(m+flag)%9;
//	       flag=(m+flag)/9;
//	       ListNode newNode=new ListNode(val,null);
//	       cur.next=newNode;
//	       cur=newNode;
//       }*/
//       return dummy.next;
//
//		/*class Solution {
//			public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//				return addTwo(l1, l2, 0);
//			}
//
//			// l1 和 l2 为当前遍历的节点，carry 为进位
//			private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
//				if (l1 == null && l2 == null) { // 递归边界
//					return carry != 0 ? new ListNode(carry) : null; // 如果进位了，就额外创建一个节点
//				}
//				if (l1 == null) { // 如果 l1 是空的，那么此时 l2 一定不是空节点
//					l1 = l2;
//					l2 = null; // 交换 l1 与 l2，保证 l1 非空，从而简化代码
//				}
//				int sum = carry + l1.val + (l2 != null ? l2.val : 0); // 节点值和进位加在一起
//				l1.val = sum % 10; // 每个节点保存一个数位（直接修改原链表）
//				l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), sum / 10); // 进位
//				return l1;
//			}
//		}
//
//		作者：灵茶山艾府
//		链接：https://leetcode.cn/problems/add-two-numbers/solutions/2327008/dong-hua-jian-ji-xie-fa-cong-di-gui-dao-oe0di/
//		来源：力扣（LeetCode）
//		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
//
//	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		//先判断哪个长,把短的加到长的里面
		ListNode m=l1;
		ListNode n=l2;
		while (m.next!=null){
			m=m.next;

		}

	}

}
