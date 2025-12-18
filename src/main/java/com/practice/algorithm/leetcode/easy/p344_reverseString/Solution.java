package com.practice.algorithm.leetcode.easy.p344_reverseString;


/**
 * LeetCode .
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {




    public void reverseString(char[] s) {
    int q=s.length-1;
        for (int i = 0; q >=i; i++,q--) {
            char z=s[i];
            s[i]=s[q];
            s[q]=z;
        }

    }
    public static void main(String[] args) {


    }
}

