package com.practice.algorithm.leetcode.Hot100.medium.p240_searchMatrix;



/**
 * LeetCode 240. 寻找
 * 题目描述： 高效寻找什么意思啊---时间复杂度降低吗?---查找就二分了,哈哈哈--算高效吗
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
         // 每一列或行用快排？---加一个判定条件是否在此列中--头尾判断一下
        // 头是否大于以及尾是否小于---然后判断
        int n=matrix.length-1;
        for (int i = 0; i <= n; i++) {
            if(matrix[i][0]>target||matrix[i][n]<target){
                continue;
            }
           //快排吗？或者二分--但是这样能高效吗?

        }

        return false;
    }
}
