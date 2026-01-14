package com.practice.algorithm.leetcode.Hot100.hard.p41_firstMissingPositive;



/**
 * LeetCode 41. 第一个未出现最小正整数
 * 题目描述：
 * 示例：  1.擦,408里面看到过---但是这个要常空间数复杂度还有o(n)时间复杂度
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {

    public int firstMissingPositive(int[] nums) {
        int firstMissing=1;
        // 目前想到的就是遍历---碰到一个就选择比他小的，如果都存在呢？---对啊
        // 最简单就是存下来---但是不能存怎么办--怎么记得有没有出现过---记当前上限和下限
        // 也就是说只能在这个范围选取--如果上下限有空余的话

        return firstMissing;
    }

}
