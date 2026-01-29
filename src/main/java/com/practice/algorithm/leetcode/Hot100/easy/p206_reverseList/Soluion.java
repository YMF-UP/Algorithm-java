package com.practice.algorithm.leetcode.Hot100.easy.p206_reverseList;



/**
 * LeetCode 206. 反转
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Soluion {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode reverseList(ListNode head) {
         // 还有点记忆---就原地反转
         // 暴力的话就是重新设一个链表--不过我记得原地好像比较好一点
        //递归比较简单--就是两两互换---但是不能传地址--直接修改吗?
      /*  ListNode nodeFirst=head;
        ListNode nodeSecond=head.next;
        while (nodeSecond!=null){


        }*/
        //不对,不对--应该是更改next---怪不得我一直觉着不对呢--那这个就是迭代了啊
        // 用三个表示--第一个、第二个、第三个
        if(head==null){
            return  head;
        }
        ListNode ftNode=head;
        ListNode sdNode=head.next;


        while (sdNode!=null) {
            ListNode tdNode = sdNode.next;
            sdNode.next=ftNode;
            ftNode=sdNode;
            sdNode=tdNode;
        }


        //迭代是怎么用呢？


        return head;
    }

}
