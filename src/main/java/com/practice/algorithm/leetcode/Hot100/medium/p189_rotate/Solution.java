package com.practice.algorithm.leetcode.Hot100.medium.p189_rotate;



/**
 * LeetCode 189.
 * 题目描述：向右轮转k个位置
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {

    public void rotate(int[] nums, int k) {
        // 1.用额外数组---比较简单
        // 2.第二种我在408里面看到过---有点印象---反转---知道怎么写了
        // 因为向右，所以第length-1-k位置开始反转---分别反转--再最后统一反转
        int len=nums.length;
        k=k%len;
        int index=nums.length-1-k;
        reverse(nums,0,index);
        reverse(nums,index+1,len-1);
        reverse(nums,0,len-1);
    }

    public static void reverse(int [] rever,int left,int right){
       while (left<right){
           int k=rever[left];
           rever[left]=rever[right];
           rever[right]=k;
           left++;
           right--;
       }
    }
}


