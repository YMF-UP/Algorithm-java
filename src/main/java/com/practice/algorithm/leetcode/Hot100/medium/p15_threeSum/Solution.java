package com.practice.algorithm.leetcode.Hot100.medium.p15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        //好像做过这一题----某不知名一天
        List<List<Integer>> sum=new ArrayList<>();
        //确实很像两数之和的哈希啊---这个不是哈希吗？---双指针吗我看标签。---不行会找到本身
        //所以必须双指针了


     /*  HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
       }*/
        //一个从头走---一个从尾走---也不对啊,这样会忽略一些情况啊
        //排序就是为了后面的推进---无论是大还是小了
        Arrays.sort(nums);   //[-1,0,1,2,-1,-4]--[-4、-1、-1、0、1、2]
        //保证必须三个
        //怎么去重啊---重复的关键在于有可能走到一样的
        for (int i = 0; i < nums.length-2; i++) {
            int right=nums.length-1;
            if(i>0){
            if(nums[i]==nums[i-1])
                continue;}
            for (int left = i+1; left <right ; ) {
               /* int m=0-nums[left]-nums[i];
                if () {
                }*/
                int k=nums[left]+nums[right]+nums[i];
                   if(k==0){
                       sum.add(Arrays.asList(nums[left], nums[right], nums[i]));
                       //加一个去重
                       while (left<right&&nums[left]==nums[left+1]) {
                           left++;
                       }
                       while (left<right&&nums[right]==nums[right-1]) {
                           right--;
                       }
                       left++;
                       right--;
                   }else if(k>0){
                       right--;
                   }else {
                       left++;
                   }
            }//那还是暴力啊，双层循环
        }
        return  sum;
    }

    public static void main(String[] args) {
        int []k={-1,0,1,2,-1,-4};
        List<List<Integer>> m=threeSum(k);
    }
}
