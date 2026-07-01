package com.practice.algorithm.leetcode.Hot100.easy.p160_getIntersectionNode;

import com.practice.algorithm.model.ListNode;

/**
 * LeetCode 160. 相交
 * 题目描述：
 * 示例：
 * 解题思路： 1.说实话--我对Java的链表是真不熟悉
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

    /*public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         // 不能操作地址--Java怎么判断呢?
         // 突然想起来怎么做了--直接看大小--放到同一个起跑线上
        int m=0;
        int n=0;
        ListNode nodeA=headA;
        ListNode nodeB=headB;
        while (nodeA!=null){
            m++;
            nodeA=nodeA.next;
        }
        while (nodeB!=null){
            n++;
            nodeB=nodeB.next;
        }
       *//* 这样写有点蠢了
        while (m>n){
            headA=headA.next;
            m--;
        }
        while (n>m){
            headB=headB.next;
            n--;
        }*//*
        while (headA!=null&&headB!=null){
            if(m>n){
                headA=headA.next;
                m--;
            } else if (n > m) {
                headB=headB.next;
                n--;
            }else {
                if(headA.equals(headB)){
                    return headB;
                }
                headA=headA.next;
                headB=headB.next;
            }
        }

        return null;
    }*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //本质就是快慢指针
        int m=0;
        int n=0;
        ListNode hA=headA;
        ListNode hB=headB;
        while (hA!=null){
            m++;
            hA=hA.next;
        }
        while (hB!=null){
            n++;
            hB=hB.next;
        }
        while (headA!=null&&headB!=null){

            if(headA.equals(headB)){
                return headA;
            }

            if(m>n){
                m--;
                headA=headA.next;
            } else if (m< n) {
                n--;
                headB=headB.next;
            }else {
                headA=headA.next;
                headB=headB.next;
            }
        }

        return null;
    }

}
