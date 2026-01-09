package com.practice.algorithm.leetcode.Hot100.medium.p560_subarraySum;

import java.util.Arrays;

public class Solution {

    public static int subarraySum(int[] nums, int k) {
      /*  //怎么感觉又是一个双指针
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
        return num;*/
        /// 题解有两个解法----我总感觉有点像238----真的
        int num=0;
        int[] sum=new int[nums.length];
//        int [] last=new int[nums.length];
        Arrays.fill(sum,0);
//        last[0]=k-nums[0];
        sum[nums.length-1]=0;
        for (int i = nums.length-2; i >=0 ;i--) {
            sum[i]=sum[i+1]+nums[i];
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(i!=nums.length-1){
                for (int j = i; j >=0 ; j--) {
                    sum[j]-=nums[i];
                }
            }
            for (int j = i; j >=0 ; j--) {
                if(nums[i]+sum[j]==k){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
         int []a=new int[]{6,4,3,1};
         int b=subarraySum(a,10);
        System.out.println(b);
    }
}
