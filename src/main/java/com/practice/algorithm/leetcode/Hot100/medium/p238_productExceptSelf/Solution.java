package com.practice.algorithm.leetcode.Hot100.medium.p238_productExceptSelf;


import java.util.Arrays;




/**
 * LeetCode 238. 除自身
 * 题目描述：
 * 示例：
 * 解题思路：其实写过一次了，刚好再试一次
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */




public class Solution {

    public static int[] productExceptSelf(int[] nums) {
       int []answer =new int[nums.length];
       //前缀和后缀---额外o(1)的话就是保留后缀
        answer[nums.length-1]=1;
        for (int i = nums.length-2; i >=0 ; i--) {
            answer[i]=answer[i+1]*nums[i+1];
        }
        int pre=1;
        for (int i = 0; i < nums.length; i++) {
            answer[i]*=pre;
            pre*=nums[i];
        }

       return answer;
    }



    public static void main(String[] args) {
         int [] n=new int[]{1,2,3,4};
         int [] b=productExceptSelf(n);
    }
}
