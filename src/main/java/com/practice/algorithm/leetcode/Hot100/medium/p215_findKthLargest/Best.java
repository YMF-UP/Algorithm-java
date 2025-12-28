package com.practice.algorithm.leetcode.Hot100.medium.p215_findKthLargest;


import java.util.Random;

public class Best {
    private Random random = new Random();
    public static   void swap(int []nums,int a,int b){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;

    }
    public int findKthLargest(int[] nums, int k) {
        //写错了--擦
        //最大的问题是---我没有意识到哪里出错了
        //3,2,1,5,6,4--4,6,5,1,2,3:j=3--5,6,4:j=1
        //从例子来看--忽略了一些东西--中间位置--一加一减间就忽略了中间---就差一点了感觉
        int left=0;
        int right=nums.length-1;
        int privot=0;

//        int m=nums.length-k;
        /** 其实是本质想错了---因为惯用的就是从两侧开始---其实对于这个算法来说是不对的---重点是分区
         *  这个分区其实是说，待整合---已整合：这两个区间---运动过程中是有三个区间的，但本质一样---之后可以思考一下
         * */
        int i;
        // while (left<right) 忽略了一个的时候，因为都在while里面，所以必须考虑到
            while (left<=right){
            i=right;
                int index = left + random.nextInt(right - left + 1);
                swap(nums,index,left);
                int value=nums[left];
            for (int j=right;j>left;j--){
                if(nums[j]<=value){
                    swap(nums,i,j);
                    i--;
                }
            }
            swap(nums,left,i);
            privot=i;
            if(privot==(k-1)){
                return nums[privot];
            }else if(privot>(k-1)){
                right=privot-1;
            }else {
                left=privot+1;
            }
        }
       /* 有问题
          while (left<right){
            int i=right;
            int j=left;
            for ( j=left;j<i;j++)
            {
                if(nums[j]<nums[i])
                {  swap(nums,j,i);
                    i--;
                }
            }
            //swap(nums,left,i);///这个总感觉少了点什么的---但是吧前面的那个for循环已经在交换了啊---还用最后来交换吗?--那交换什么呢?--还是得看一下了
            privot=j;
            if(privot==(k-1)){
                return  nums[privot];
            } else if (privot>(k-1)) {
                right=privot-1;
            }else {
                left=privot+1;
            }
        }*/
        return -1;//不存在
    }

    public static void main(String[] args) {

    }
}
