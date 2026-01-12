package com.practice.algorithm.leetcode.Hot100.medium.p53_maxSubArray;



/**
 * LeetCode 53.
 * 题目描述：
 * 示例：
 * 解题思路：题解的解法有很多----但我一个都没发觉---贪心绝对可以做
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {

    public static int maxSubArray(int[] nums) {
         /*  int maxSum=nums[0];
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
           return maxSum;*/

        ///  关键点是状态---1.什么时候统计?  2.什么位置重新开始?
        ///  我觉着我想的是对的---子数组里面将要出现第二个负数就计算,但是我对于第二个问题没有思考好
        ///  什么位置开始呢？----负数的下一位---不对，那就可以优化了---直接用和减去第一个负数，然后继续---
        ///  不对，负数可能出现在中间位置--所以记录一下
        int maxSum=Integer.MIN_VALUE;
        int staticSum=0;
        int flagMinus=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                flagMinus++;

            }
            if(flagMinus==2){

            }
        }

        return maxSum;

      /*  class Solution {
            public int maxSubArray(int[] nums) {
                int pre = 0, maxAns = nums[0];
                for (int x : nums) {
                    pre = Math.max(pre + x, x);
                    maxAns = Math.max(maxAns, pre);
                }
                return maxAns;
            }
        }

        作者：力扣官方题解
        链接：https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }

    public static void main(String[] args) {
        int [] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
