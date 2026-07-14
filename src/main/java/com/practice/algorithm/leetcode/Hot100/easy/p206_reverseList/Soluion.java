package com.practice.algorithm.leetcode.Hot100.easy.p206_reverseList;


import com.practice.algorithm.model.ListNode;

/**
 * LeetCode 206. 反转
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Soluion {

//    public ListNode reverse(ListNode node){
//        ListNode newNode;
//        if(node.next!=null&&node!=null){
//            newNode=reverse(node.next);
//            ListNode f=node.next;
//            f.next=node;
//            node.next=null;
//            return newNode;
//        }
//        else {
//            return node;
//        }
//      /*  // 1. 基准条件（处理 null 和尾节点）
//        if (node == null || node.next == null) {
//            return node;
//        }
//
//        // 2. 递归（不需要提前声明 newNode）
//        ListNode newHead = reverse(node.next);
//
//        // 3. 反转当前这对指针
//        node.next.next = node;
//        node.next = null;
//
//        // 4. 层层上报新头
//        return newHead;*/
//
//    }
//
//      public class ListNode {
//          int val;
//          ListNode next;
//          ListNode() {}
//          ListNode(int val) { this.val = val; }
//          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//      }
//    public ListNode reverseList(ListNode head) {
//         // 还有点记忆---就原地反转
//         // 暴力的话就是重新设一个链表--不过我记得原地好像比较好一点
//        //递归比较简单--就是两两互换---但是不能传地址--直接修改吗?
//      /*  ListNode nodeFirst=head;
//        ListNode nodeSecond=head.next;
//        while (nodeSecond!=null){
//
//
//        }*/
//        //不对,不对--应该是更改next---怪不得我一直觉着不对呢--那这个就是迭代了啊
//        // 用三个表示--第一个、第二个、第三个
//        if(head==null){
//            return  head;
//        }
//
//      /**  ListNode ftNode=head;
//        ListNode sdNode=head.next;
//
//        ftNode.next=null;
//        while (sdNode!=null) {
//            ListNode tdNode = sdNode.next;
//            sdNode.next=ftNode;
//            ftNode=sdNode;
//            sdNode=tdNode;
//        }
//        */
//
//        //迭代是怎么用呢？
//        //其实是递归--上面那个是迭代
//        ListNode node=reverse(head);
//        return node;
//    }

   /* public ListNode reverseList(ListNode head) {
        //迭代倒是很很容易,就是递归不会
        if(head==null){
            return head;
        }
        ListNode cur=head.next;
        head.next=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=head;
            head=cur;
            cur=next;
        }
        return head;
    }*/

	public ListNode reverseList(ListNode head) {
		//用递归写确实在边界和返回上面是个难点
		if(head==null||head.next==null){
			return head;
		}
		ListNode cur=reverseList(head.next);//尾巴也就是当前需要改变成为的头
		cur.next=head;
		head.next=null;
		//怎么返回呢?
		return
	}

}
