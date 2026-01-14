package com.practice.algorithm.leetcode.Hot100.medium.p73_setZeroes;

public class Solution {

    public void setZeroes(int[][] matrix) {
       //只记录行和列那也是o(m+n)---但是我对二维数组确实不熟悉
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 关键就是判断这个是不是初始0还被改变的0,
                // 从列开始遍历的话--碰到0的话,就是判断这一列的上一行或下一行是否为0--不对--边界单独考虑吗？
                if(matrix[i][j]==0){

                }
            }
        }
    }

}
