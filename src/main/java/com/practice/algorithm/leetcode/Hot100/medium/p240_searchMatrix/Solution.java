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

    public static boolean searchMatrix(int[][] matrix, int target) {
      /*   // 每一列或行用快排？---加一个判定条件是否在此列中--头尾判断一下
        // 头是否大于以及尾是否小于---然后判断
        int n=matrix.length-1;
        for (int i = 0; i <= n; i++) {
            if(matrix[i][0]>target||matrix[i][n]<target){
                continue;
            }
           //快排吗？或者二分--但是这样能高效吗?

        }

        return false;*/

        // 关键就是一次剔除一行或者一列按照左下角--右上角这种--不停的缩小范围--只考虑角落,复杂度自然就低
        // 肯定能剔除一行或者一列--如果左下角小于就移动,直到大于--然后移动右上角--明白了无论大于小于都可以移动右上角
        // 不对不对,左下角也是可以的---就大于的话就排除行,小于就排除列,没错都一样的
        int row= matrix.length-1;
        int list=0;

        // 终止条件是达到顶点--行是到0,列是到最终的
        while (row>=0&&list<matrix[0].length){
            if (matrix[row][list]==target){
                return true;
            }
            while (list<matrix[0].length&&matrix[row][list]<target){
                list++;
            }
            while (row>=0&&matrix[row][list]>target){
                row--;
            }
        }
        return  false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean test=searchMatrix(matrix,target);
    }
}
