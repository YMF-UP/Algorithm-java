package com.practice.algorithm.leetcode.Hot100.hard.p41_firstMissingPositive;


import com.practice.utils.Swap;

/**
 * LeetCode 41. 第一个未出现最小正整数
 * 题目描述：
 * 示例：  1.擦,408里面看到过---但是这个要常空间数复杂度还有o(n)时间复杂度
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {

    public static void swap(int []nums,int left,int right ){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public int firstMissingPositive(int[] nums) {
        // int firstMissing=1;   没什么用
        // 目前想到的就是遍历---碰到一个就选择比他小的，如果都存在呢？---对啊
        // 最简单就是存下来---但是不能存怎么办--怎么记得有没有出现过---记当前上限和下限
        // 也就是说只能在这个范围选取--如果上下限有空余的话

        /// 确实是我想不到的---原地哈希--像是一个思维角落被揭起来一样
        int len=nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i+1){
                if(nums[i]>len||nums[i]<=0||nums[nums[i]-1]==nums[i]){
                    break;
                }
              swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }



}
