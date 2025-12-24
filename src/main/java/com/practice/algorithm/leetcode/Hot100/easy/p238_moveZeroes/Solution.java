package com.practice.algorithm.leetcode.Hot100.easy.p238_moveZeroes;

import java.util.Arrays;

public class Solution {


    public void moveZeroes(int[] nums) {
        int k=1;
        int m=0;
        //关键在于状态变化
        while (k<nums.length){
            if(nums[m]==0&nums[k]!=0){
                nums[m]=nums[k];
                nums[k]=0;
                m++;
            }
           else if (nums[m]!=0){
               m++;
            }
           k++;
        }

      /*   不应该这么写，不应该从两端---应该是同时走--多一位
        //不算太难，就是怎么能够同时在排序同时置换---想到了快排
        int k=nums.length-1;
        int m=0;
        //先把零放后面
        while (k>m){
            while (nums[m]!=0&k>m)
                m++;
            while (nums[k]==0&k>m)
                k--;
            int l=nums[m];
            nums[m]=nums[k];
            nums[k]=l;
        }
        *//* 搞错了---是相对顺序了
        //排序，从0到k/m
        Arrays.sort(nums,0,k);*/
    }

   /** 官方题解
     class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }*/






    public static void main(String[] args) {

    }
}
