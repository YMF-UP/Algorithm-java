package com.practice.algorithm.leetcode.Hot100.medium.p73_setZeroes;

public class Solution {

    public void setZeroes(int[][] matrix) {
      /* //只记录行和列那也是o(m+n)---但是我对二维数组确实不熟悉
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 关键就是判断这个是不是初始0还被改变的0,
                // 从列开始遍历的话--碰到0的话,就是判断这一列的上一行或下一行是否为0--不对--边界单独考虑吗？
                if(matrix[i][j]==0){

                }
            }
        }*/

        //先处理第一行和第一列目的是为了之后被代替了，但是没有把对应的及时变为0---要标记
        //但是为什么处理的时候要跳过第一行第一列呢？---担心存储的被改变了---不对啊这样
        //标记的是除第一行和第一列其余为0的吗？---第一行第一列是的,第一行和第一列单独标记
        boolean firstRow=false;
        boolean firstList=false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                firstList=true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                firstRow=true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //然后处理第一行和第一列---已经是标记的了---行处理行，列处理列--但是[0][0]不处理
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        if(firstRow){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        if(firstList){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }

}
