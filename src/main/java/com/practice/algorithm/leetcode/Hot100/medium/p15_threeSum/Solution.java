package com.practice.algorithm.leetcode.Hot100.medium.p15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        //好像做过这一题----某不知名一天
        List<List<Integer>> sum=new ArrayList<>();
        //确实很像两数之和的哈希啊---这个不是哈希吗？---双指针吗我看标签。---不行会找到本身
        //所以必须双指针了

      /* 不对了就
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i:nums){
           map.put()
       }*/
        //一个从头走---一个从尾走---也不对啊,这样会忽略一些情况啊
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int second=nums[i];
            int right=nums.length-1;
            for (int left = i+1; left <right ; ) {
                   if(nums[left]+nums[right]==(-second)){
                       sum.add(Arrays.asList(nums[left], nums[right], nums[i]));
                   }else if(nums[left]+nums[right]>(-second)){
                       right--;
                   }else {
                       left++;
                   }
            }//那还是暴力啊，双层循环
        }
        return  sum;
    }
}
