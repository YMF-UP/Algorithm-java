package com.practice.algorithm.leetcode.Hot100.hard.p239_maxSlidingWindow;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
       int [] max=new int[nums.length-k+1];
       //暴力写的话就是双循环---怎么优化呢？--就判断？
       //优化肯定不行--如果只这样的话---那该怎么处理呢？
       //越看越像堆--但是复杂度的话---堆排序啊也是---全部n个，那复杂度也很大
       //考虑最坏情况暴力的----降序---所以优化怎么处理？--只有记录了---但是怎么记录呢？--数组、哈希都不行
        int index=-1;
        int j=0;
      /*  for (int i = 1; i < k; i++) {
            if(nums[index]<nums[i]){
                index=i;
            }
        }*/
        for (int i = 0; i <= nums.length-k; i++) {
           if(i>index){
               index=i;
               for (int l = i+1; l < i+k; l++) {
                   if(nums[index]<nums[l]){
                       index=l;
                   }
               }

           }else if(nums[i+k-1]>nums[index]){
               index=i+k-1;
           }
            max[j++]=nums[index];
        }
       return max;
    }


    public static void main(String[] args) {
      int []test=new int[]{1,3,-1,-3,5,3,6,7};
      int k=3;
      int [] result=maxSlidingWindow(test,k);
    }
}
