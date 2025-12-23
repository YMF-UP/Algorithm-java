package com.practice.algorithm.leetcode.Hot100.medium.p128_longestConsecutive;


import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128.
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

    public static int longestConsecutive(int[] nums) {
        //关键点在于怎么判断---hash吗
        /**1.没想到之前居然写出来过---虽然是c++
         * 2.现在反而写不出来了，---果然不进反退啊
         * */
        int flag=0;
        Set<Integer> sum=new HashSet<>();
        for (Integer i : nums){
              sum.add(i);
        }
//        for (Integer i :nums) 这个会超出时间限制，哈希是有去重功能的，所以哈希set稍短一些
        for (Integer i :sum){
            if(!sum.contains(i-1)){
                int m=i;
                int k=1;
                while (sum.contains(m+1)){
                    m++;
                    k++;
                }
                if (k>flag){
                    flag=k;
                }
            }
        }
        return  flag;
    }


        public static void main(String[] args) {
        int[] nums=new int[]{100,4,200,1,3,2};
         int m= longestConsecutive(nums);

    }
}
