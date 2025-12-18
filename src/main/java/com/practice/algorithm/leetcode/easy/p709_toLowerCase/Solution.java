package com.practice.algorithm.leetcode.easy.p709_toLowerCase;


/**
 * LeetCode .
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)StringBuilder的空间复杂度要低一些，StringBuilder适合操作
 */

public class Solution {

    public static   String toLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
                   s=s.replace(s.charAt(i),(char)(s.charAt(i)+32));


        }
        return  s;
    }


    public static void main(String[] args) {

        String S=toLowerCase("Hello");

    }

}
