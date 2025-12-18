package com.practice.algorithm.leetcode.easy.p121_maxProfit;

/**
 * 感觉自己举一反三的能力很弱，弱的原因就是没有把那个一完全搞明白，也就是最原本的，
 * 为什么呢？为什么没有搞懂呢？以这一个股票为例子吧
 * 1.就是没有搞明白卖出的含义
 * 1.1我一直认为卖出就是根据前一次交易的买入来进行判断的，其实并不是，而是这次交易的前一个股票和后一个股票哪一次参与卖出去更合适
 * 1.2还是没有理解交易这个东西，本质其实是一次交易来作为整体判优。
 * 1.3对于dp最重要的是状态转移，但我一直没搞太明白，稀里糊涂的去写，自然不对。状态转移图还真需要想一想。
 * 2.其实就是基础能力不扎实
 * 2.1比如说调试过程就没有多熟悉，丧失了更改还有解决的机会
 */
import java.util.Scanner;

/**
 * LeetCode 121. 最大
 * 题目描述：
 * 示例：
 * 解题思路：1.线性思维肯定不行，要考虑一下其他的了。主要暴力就是双for了。
 *         2.如果用双差值呢，也是两个for了，但是依然是线性。
 *         3.果然啊，是dp的思路，但是如何创建二维数组比较重要
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */




public class Solution {

    public static  int maxProfit(int k,int[] prices)
   {  //188
       /*1.已知123的第二次购买是使用前一个卖出结果来确定，那k次呢？
       * 2.k次应该也是需要k-1次做决定，那本质还是依靠第一次，无非多循环几次，不知道对不对，
       * 3.因为我看的解析没有用传统dp来做。现如今是要用传统dp数组来做吗？二维还是三维数组？
       * 3.1二维的话其实就是买和卖，分别两列。多个k也就是多一个维度判断
       * 第k次买不买就是去k-1那个判断，对吧。
       * */
       int max=0;
       int [][][]dp=new int [prices.length][2][k];
       //dp[][0][]:表示买，dp[][1][]:表示卖
       //初始化一下吗要？--好像需要
       for (int i = 0; i < k; i++) {
           dp[0][0][i]=0-prices[0];//买
           dp[0][1][i]=0;//卖
       }
       for (int i = 1; i < prices.length; i++) {
           //哦对，还有边界要考虑
           for (int j = 0; j < k; j++) {
               if(j!=0)
               {   //先卖还是先买，有点拿不准了？
                   //决定两者的关键是是否依靠上一位？
                   //要先卖，因为卖需要上一次的买的价格，第一次无所谓。
                   dp[i][1][j]=Math.max(dp[i-1][1][j],prices[i]+dp[i-1][0][j]);//卖
                   dp[i][0][j]=Math.max(dp[i-1][0][j], dp[i-1][1][j-1]-prices[i]);//买
               }
               else
               {
                   dp[i][1][0]=Math.max(dp[i-1][1][0],prices[i]+dp[i-1][0][0]);//卖
                   dp[i][0][0]=Math.max(dp[i-1][0][0],-prices[i]);//买

               }
           }
       }
       return dp[prices.length-1][1][k-1];



       ////*123，到头来还是没写出来，惭愧啊。看一下188，既然已经看了解析
//         1.还是想不通怎么用dp来做。
//         2.目前对dp的了解就只在于背包问题---当前最优解吗不是。当然还是从整体考虑
//         3.整体的话，买不买和卖不卖两个维度了，背包只有一个维度就是放不放。
//               */
//        int max1=0,max2=0;
//        int max=0;//卖出价格
//        int k=0;
//        int sum=0,flag=0;
//        //int min=Integer.MAX_VALUE;//买入
//        int [] num=new int[prices.length];
//        //第一个循环，找差值
//        for (int i = 0; i < prices.length-1; i++) {
//            num[k++]=prices[i+1]-prices[i];
//        }
//        //如果相邻为正，可以看作是一笔交易，然后记录下来去继续找大于0的，要比较找到最大的两个。
//        //忽略了一点就是，应该是连续为正的话，而不只是两个
//        // 从dp角度去想的话，是说或者说从差值里面建立转移方程吗？
//        for (int i = 0; i <k ; i++) {
//            if(num[i]>0&&num[i+1]>0)
//            {    sum=num[i]+num[i+1];
//                if(sum>max1)
//                {
//                    max2=max1;
//                    max1=sum;
//                } else if (sum>max2) {
//                    max2=sum;
//                } //就是说最大的两个记录在案。逻辑错了,应该是两个大的，大根堆吗，啊哈哈。
//              } else
//               {
//                if(num[i]>max1)
//                {
//                    int l=max1;
//                    max1=num[i];
//                    max2=l;
//                }
//                else if (num[i]>max2)
//                    max2=num[i];
//               }
//
//        }
//        max=max1+max2;
//        return max;


////         122.变种题目，其实没变多少，123才是挑战。
//          int max=0;//卖出价格
//          int min=Integer.MAX_VALUE;//买入价格
//        for (int i = 0; i < prices.length; i++) {
//            if(min>prices[i])
//            {
//                min=prices[i];
//            }//确定买的时间
//            if(prices[i]-min>0)
//            {
//                max+=prices[i]-min;
//                min=prices[i];//卖出去了，同时再买回来。不对，大于max不对。
//            }
//        }
//        return max;

          //2.不对。这是121，感觉确实想到了整体状态，但是没有去想到dp,z子问题拆解还是有点难度，
//          int []last=new int[prices.length-1];
//        for (int i = 0; i < prices.length; i++) {
//            last[i]=prices[i+1]-prices[i];
//            if(flag<last[i])
//                flag=last[i];
//        }
//        int m=0;
//        for (int i = 0; i < last.length; i++) {
//            if (last[i] >0&&last[i+1]>0) {
//                m+=last[i]+last[i+1];
//            } else if (last[i] < 0 && last[i + 1] > 0) {
//                if((last[i+1]-Math.abs(last[i]))>0&&last[i-1]>0){
//                       int q=last[i+1]+last[i]+last[i-1];
//                }
//            }
//
//        }
        //1.不太对啊
//        for (int i = 0; i <last.length-1 ; i++) {
//            if(last[i+1]-Math.abs(last[i])>=0){
//                m+=last[i+1];//缺了一个东西，就是判断怎么取利润，也就也是比较
//            } else if (flag<last[i]) {
//                flag=last[i];
//            }//这个else是避免负和正
//
//        }//感觉还是不对，只能顾及周围的三个数，无法整体找到最大最小差值。
//        //还是尝试写一下吧，没思路，情况太多了。

    }

    public static void main(String[] args) {
     int [] m=new int[]{3,2,6,5,0,3};
     int max=maxProfit(2,m);
        System.out.println(max);
}
}
