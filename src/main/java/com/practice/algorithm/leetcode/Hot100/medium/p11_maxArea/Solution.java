package com.practice.algorithm.leetcode.Hot100.medium.p11_maxArea;

public class Solution {


    public int maxArea(int[] height) {

        //其实也就是求面积---最大的肯定是长和宽最大了---所以双指针了就,确定了长，从最长的长开始判断
        int max=0;
        int right=0;
        int left=height.length-1;
        //让较小的height往前走
        while (left>right){

            int m=left-right;//长
            int k=Math.min(height[right],height[left]);//宽
            if(height[right]==k){
                right++;
            }
            else {
                left--;
            }
            if(m*k>max){
                max=m*k;
            }
        }        return  max;
    }

   /** 官方题解---是要简练一些的
    *  public class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;
        }
    }
    */


    public static void main(String[] args) {

    }

}
