package com.practice.algorithm.leetcode.medium.p238_productExceptSelf;


import java.util.Arrays;



/**
 * LeetCode 238. 相乘
 * 题目描述：
 * 示例：
 * 解题思路：1.要求o(n)的时间复杂度，这个不用双for怎么处理呢
 *         2.如果从两边角度去考虑，那也没有记录啊，毕竟只有一个for啊
 *         3.累乘的这个思路的话----怎么记录啊？--怎么连续乘啊？
 *
 *         果然还是太蠢了，擦，能想到累乘，确想不到记录左右，然后再乘，
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {


    public static int[] productExceptSelf(int[] nums) {
        int[] mix=new int[nums.length];
        int[] left=new int[nums.length];
        int[] right =new int[nums.length];
        Arrays.fill(right,1);
        Arrays.fill(left,1);
        for (int i = 1; i < nums.length; i++) {
                right[nums.length-1-i]=right[nums.length-i]*nums[nums.length-i]; //右边是倒序
                left[i]=left[i-1]*nums[i-1];//左边是正序
        }
        for (int i = 0; i < right.length; i++) {
            mix[i]=right[i]*left[i];
        }
        return mix;
    }

    public static void main(String[] args) {
         int [] n=new int[]{1,2,3,4};
         int [] b=productExceptSelf(n);
    }
}
