package com.practice.algorithm.leetcode.Hot100.medium.p48_rotate;

public class Solution {

    public void rotate(int[][] matrix) {
        // 我的想法就是旋转---那就开始一个接一个旋转呗---n-1最外层，随后减2--嵌套一个循环--用于每一个的替换
        // 重点就是内层的循环---当前位置加移动位置随后求行的余数
        // 对角线方式处理层数---0,0-1,1
        // 不行---调换还是太难--也就是内部的那个循环
       /* int n=matrix.length-1;
         while (n!=0){
             int
             for (int i = 0; i < ; i++) {

             }
         }*/

        //先对折然后再对称翻转---好处在于下标方便处理---是的,这个最重要
        //从对角线开始进行下去--然后竖着对称翻转
        int n=matrix.length;
        //对角线
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //翻转--从中间位置开始
        //奇数行和偶数行的不一样处理吗?--当然了,一个不变一个改变--中间行--不用不用,从两端开始就行了
        for (int i = 0; i <n; i++) {
            int m=n-1;
            for (int j = 0; j < m; j++,m--) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m];
                matrix[i][m]=temp;
            }
        }


    }

}
