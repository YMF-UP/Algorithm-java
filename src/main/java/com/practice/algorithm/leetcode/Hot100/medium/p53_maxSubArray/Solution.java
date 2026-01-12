package com.practice.algorithm.leetcode.Hot100.medium.p53_maxSubArray;

public class Solution {

    public static int maxSubArray(int[] nums) {
           int maxSum=nums[0];
           //感觉又是一个纯模拟呢---出现两个负数就取消往下走，并计算当前子数组之和
           //这样来看---栈和队列也能写
          int flagMinus=0;
          int index=0;
          int staticSum=0;
        while (index<nums.length&&nums[index]<0){
            index++;
        }
          while (index<nums.length){

              if(nums[index]<0){
                  flagMinus++;
              }
              if(flagMinus!=2){
                  staticSum+=nums[index];
                  index++;
                  maxSum=Math.max(staticSum,maxSum);
              }else {
                  maxSum=Math.max(staticSum,maxSum);
                  staticSum=0;
                  flagMinus=0;
                  while (nums[index]<0){
                      index++;
                  }
              }
          }
           return maxSum;
    }

    public static void main(String[] args) {
        int [] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
