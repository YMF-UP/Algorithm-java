package com.practice.algorithm.leetcode.easy.p1480_running_sum;




/**
 * LeetCode .
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)O(n),可以优化，直接在本来的数组处理
 */


public class Solution {

    public static int[] runningsum(int[] sums) {
        int [] sum = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            if(i!=0)
            sum[i]=sums[i]+sum[i-1];
            else
                sum[i]=sums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int [] sums={1,2,3,4};
        int [] nums=runningsum(sums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }


    }
}
