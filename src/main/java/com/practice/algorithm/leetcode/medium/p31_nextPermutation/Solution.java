package com.practice.algorithm.leetcode.medium.p31_nextPermutation;



/**
 * LeetCode 31.
 * 题目描述：
 * 示例：
 * 解题思路：
 *         1.感觉像是冒泡的变种，变成从后开始了。
 *         2.其实就是慢慢的升序变为降序.
 *         3.怎么感觉是递归啊，不用递归不行吧
 *         4.不行还是没什么思路
 *         5.还是从前往后，感觉还是
 *         6.双for吗，判断
 *
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

//果然不会，看来下周要自己写一下了，擦，看完题解感觉很简单啊。
public class Solution {


    public void nextPermutation(int[] nums) {
        int flag=0;
        int k=0;//判断
       /* for (int i = 0; i <nums.length-1; i++) {
            if(nums[i]<nums[i+1])
            {
                  flag=1;
            }
        }*/
        for (int i = nums.length-1; i >0; i--) {
            if(nums[i]>nums[i-1]){

            }

        }
    }

    public static void main(String[] args) {

    }
}
