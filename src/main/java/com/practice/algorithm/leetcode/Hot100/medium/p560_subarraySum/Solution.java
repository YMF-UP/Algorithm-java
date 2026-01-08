package com.practice.algorithm.leetcode.Hot100.medium.p560_subarraySum;

public class Solution {

    public static int subarraySum(int[] nums, int k) {
        //怎么感觉又是一个双指针
        //求和怎么去看状态，不行吧--不能像之前那样抽象出来
        //左移动就减去，右移动就加上---left为终点的时候就到此为止---right一定大于等于left
        //right等于left的时候感觉多了很多判断啊--小于k，大于k，等于k。纯判断了啊
        //抽象状态就是大于，小于，等于
        //不过怎么也是贪心和模拟了啊
        int num=0;
        int left=0;
        int right=0;
        int sum=nums[0];
//        if (sum==k){
//            num++;
//            left++;
//        } else if (sum>k) {
//            sum-=nums[left];
//           left++;
//        }
        while (right<nums.length){
           while (left<right){
              if(sum>k){
                  sum-=nums[left];
                  left++;
              } else if (sum<k) {
                  sum+=nums[right];
                  right=Math.min(nums.length-1,right+1);
              }else if(sum<k&&right==nums.length-1){
                  sum-=nums[left];
                  left++;
              } else if (sum==k) {
                  num++;
                  sum-=nums[left];
                  left++;
                  right=Math.min(nums.length-1,right+1);
              }
           }
           if (sum==k){
               num++;
               sum-=nums[left];
               left++;
               right++;
           } else if (sum>k) {
               sum-=nums[left];
               left++;
               right++;
           }else if(right<nums.length){
               right++;
           }
        }
        return num;
    }

    public static void main(String[] args) {
         int []a=new int[]{1,1,1};
         int b=subarraySum(a,2);
        System.out.println(b);
    }
}
