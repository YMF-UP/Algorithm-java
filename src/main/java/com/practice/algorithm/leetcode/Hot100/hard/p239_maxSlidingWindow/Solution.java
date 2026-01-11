package com.practice.algorithm.leetcode.Hot100.hard.p239_maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
      /* int [] max=new int[nums.length-k+1];
       //暴力写的话就是双循环---怎么优化呢？--就判断？
       //优化肯定不行--如果只这样的话---那该怎么处理呢？
       //越看越像堆--但是复杂度的话---堆排序啊也是---全部n个，那复杂度也很大
       //考虑最坏情况暴力的----降序---所以优化怎么处理？--只有记录了---但是怎么记录呢？--数组、哈希都不行
        int index=-1;
        int j=0;
      *//*  for (int i = 1; i < k; i++) {
            if(nums[index]<nums[i]){
                index=i;
            }
        }*//*
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
       return max;*/
        int [] result=new int[nums.length-k+1];
        ///题解---队列--先自己写一下啊
        Deque<Integer> deque=new ArrayDeque<>();
        /// 关键点在于判断---进入和退出--严格降序
        /// 放的是下标

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            //小于的时候还加入吗？
            deque.addLast(i);
        }
        result[0]=nums[deque.getFirst()];
        for (int i=k;i<nums.length;i++){
            if(!deque.isEmpty()){
                while (!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
                    deque.removeLast();
                }
                if(!deque.isEmpty()&&deque.getFirst()<i-k+1){
                    deque.removeFirst();
                }
            }
            deque.addLast(i);
            result[i-k+1]=nums[deque.getFirst()];
        }

        return result;

/**              ai给的最优算法实例
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) return new int[0];

            int[] result = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();

            // 只用一个循环搞定所有
            for (int i = 0; i < nums.length; i++) {
                // 1. 【出队】如果队首元素（下标）已经不在窗口范围内了，移除它
                // 窗口左边界是 i - k，队首小于等于这个值说明不在窗口内
                if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                    deque.removeFirst();
                }

                // 2. 【入队】维护单调递减队列
                // 如果当前元素比队尾大，队尾就没有机会成为最大值了，直接删掉
                while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i);

                // 3. 【记录结果】
                // 只有当 i 走到 k-1（第一个窗口的末尾）时，才开始记录结果
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.getFirst()];
                }
            }
            return result;
        }*/

    }


    public static void main(String[] args) {
      int []test=new int[]{1,3,-1,-3,5,3,6,7};
      int k=3;
      int [] result=maxSlidingWindow(test,k);
    }
}
