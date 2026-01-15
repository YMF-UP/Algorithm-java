package com.practice.algorithm.leetcode.Hot100.medium.p54_spiralOrder;

import java.util.ArrayList;
import java.util.List;



/**
 * LeetCode 54.
 * 题目描述：螺旋矩阵
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        // 碰到尽头就转弯---重点就是尽头---其实就是每转两次弯一次就少一个，除了第一次
        // 特殊处理第一行
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(matrix[0][i]);
        }
        //其余要记录一下了---每两次减一个
        //怎么转弯
        //不对--不对:就是这样---所以现在问题就是如何转弯了?--列行这个顺序
        //终止条件就是某一个标志为0了
        int flagRow=matrix.length-1;
        int flagList=0;
        int k=1;
        //奇数和偶数吗？决定不一样的遍历方向--一个向下和像左;一个向上和向右
        //得还有一个决定行和决定列的
        int statueRow=1;
        int statueList=matrix[0].length-1;
        while (flagRow!=0&&flagList!=0){
            if(k%2!=0){
               /* for (int i = statueRow; i <=flagRow; i++) {
                    list.add(matrix[i][statueList]);
                }
                statueList++;
                for (int j = statueList; j>=flagList; j--) {
                        list.add(matrix[flagRow][j]);
                }*/
                for (  ; statueRow <=flagRow ; statueRow++) {
                    list.add(matrix[statueRow][statueList]);
                }
                statueList--;
                for ( ; statueList >=flagList; statueList--) {
                    list.add(matrix[statueRow][statueList]);
                }
                statueRow--;
                flagRow=
                k++;
            }else {


            }

        }


        return list;
    }
}
