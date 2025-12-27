package com.practice.algorithm.leetcode.Hot100.medium.p215_findKthLargest;

public class Best {
    public static   void swap(int []nums,int a,int b){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;

    }
    public int findKthLargest(int[] nums, int k) {
        //写错了--擦
        int left=0;
        int right=nums.length-1;
        int privot=0;
        while (left<right){
            int i=right;
            for ( int j=left;j<i;j++)
            {
                if(nums[j]>nums[i])
                {  swap(nums,j,i);
                    i--;
                }
            }
            //swap(nums,);///这个总感觉少了点什么的---但是吧前面的那个for循环已经在交换了啊---还用最后来交换吗?--那交换什么呢?--还是得看一下了
            privot=i;
            if(privot==(k-1)){
                return  nums[privot];
            } else if (privot>(k-1)) {
                right=privot-1;
            }else {
                left=privot+1;
            }
        }
        return -1;//不存在
    }

    public static void main(String[] args) {

    }
}
