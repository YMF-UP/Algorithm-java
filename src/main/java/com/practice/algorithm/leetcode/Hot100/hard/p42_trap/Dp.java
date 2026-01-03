package com.practice.algorithm.leetcode.Hot100.hard.p42_trap;


import java.util.Arrays;

public class Dp {

    /// 这是错误的dp学习思路---我正在改变和学习
    //动态规划思路吗？----water=min-now---然后更新
    public static int trap(int[] height) {
          int []water=new int[height.length-1];
        Arrays.fill(water,0);
          int left=0,right=height.length-1;
          int sum=0;
          int leftMax=0,rightMax=0;
          //怎么感觉是双指针了啊---双指针的代码都背下来了---越看越想---应该是我还不会吧动态规划
        while (left<right){
         if(height[left]<height[right]){
             if(height[left]>leftMax){
                 leftMax=height[left];
             for (int i = left+1; i < water.length&&i<right; i++) {
                 int k=height[left]-height[i];
                 if(k>water[i]){
                     water[i]=k;
                 }
               }
             }
             left++;
         }else {
             if(height[right]>rightMax){
                 rightMax=height[right];
             for (int i = left+1; i < water.length&&i<right; i++) {
                 int k=height[right]-height[i];
                 if(k>water[i]){
                     water[i]=k;
                 }
               }
             }
             right--;
         }
        }//动一次就更新一次吗？太复杂了---但是取决于的不就是最新的吗？---这也太暴力了啊
        for (int i = 0; i < water.length; i++) {
            sum+=water[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int [] nu={5,4,1,2};
        int m=trap(nu);
        System.out.println(m);
    }
}
