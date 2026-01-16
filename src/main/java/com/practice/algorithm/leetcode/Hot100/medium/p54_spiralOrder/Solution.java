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

    public static List<Integer> spiralOrder(int[][] matrix) {
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
                for (int i = statueRow; i <=flagRow; i++) {
                    list.add(matrix[i][statueList]);
                }
                statueList++;
                for (int j = statueList; j>=flagList; j--) {
                        list.add(matrix[flagRow][j]);
                }
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
      /*  ///  还是想不到啊怎么--有时候是差一点--有时候差了好多
        List<Integer> res=new ArrayList<>();
        int Dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};//这个确实挺牛的
        int dir=0;
        int i=0,j=0;
        int m=matrix.length;
        int n=matrix[0].length;
        for (int k = 0; k <m*n ; k++) {

           *//* // 具体处理--但是怎么确定这个方向的加减呢?---怎么往下走呢?---所以Dir方向是开始又是增加的
            // 怎么知道是行还是列变化呢?---dir决定的---好像有点问题这个判断条件
            while (i>=0&&i<m&&j>=0&&j<n&&matrix[i][j]!=Integer.MAX_VALUE){
              res.add(matrix[i][j]);
              matrix[i][j]=Integer.MAX_VALUE;
              i+=Dir[dir][0];
              j+=Dir[dir][1];
              k++;
            }
            i-=Dir[dir][0];
            j-=Dir[dir][1];
            dir++;
            dir%=4;
            i+=Dir[dir][0];
            j+=Dir[dir][1];*//*
            res.add(matrix[i][j]);
            matrix[i][j]=Integer.MAX_VALUE;
            int nexti=i+Dir[dir][0];
            int nextj=j+Dir[dir][1];
            if (nexti<0||nexti>=m||nextj<0||nextj>=n||matrix[nexti][nextj]==Integer.MAX_VALUE){
                dir=(dir+1)%4;
            }
            i+=Dir[dir][0];
            j+=Dir[dir][1];

        }
        return res;*/

        /// 其实步长也能做---比我之前想的状态处理要简单一些
       /* List<Integer> res=new ArrayList<>();
        int rows=matrix.length;
        int lists=matrix[0].length;
        int flagorow=0;
        int flagList=0;
        while (rows>=0||lists>=0){
            // 步长的话,问题也是转向
            for ( flagList = 0; flagList < rows; flagList++) {
                res.add(matrix[flagorow][flagList]);
            }
            for (int flaglist = 0; flaglist < ; flaglist++) {

            }

        }
        return res;*/

//        class Solution {
//            private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
//
//            public List<Integer> spiralOrder(int[][] matrix) {
//                int m = matrix.length;
//                int n = matrix[0].length;
//                int size = m * n;
//                List<Integer> ans = new ArrayList<>(m * n); // 预分配空间
//                int i = 0;
//                int j = -1; // 从 (0, -1) 开始
//                for (int di = 0; ans.size() < size; di = (di + 1) % 4) {
//                    for (int k = 0; k < n; k++) { // 走 n 步（注意 n 会减少）
//                        i += DIRS[di][0];
//                        j += DIRS[di][1]; // 先走一步
//                        ans.add(matrix[i][j]); // 再加入答案
//                    }
//                    int tmp = n;
//                    n = m - 1; // 减少后面的循环次数（步数）
//                    m = tmp;
//                }
//                return ans;
//            }
//        }
//
//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/spiral-matrix/solutions/2966229/liang-chong-fang-fa-jian-ji-gao-xiao-pyt-4wzk/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static void main(String[] args) {
        int ma[][]={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res=spiralOrder(ma);

    }
}
