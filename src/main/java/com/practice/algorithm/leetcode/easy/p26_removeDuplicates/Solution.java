package com.practice.algorithm.leetcode.easy.p26_removeDuplicates;


/**
 * LeetCode .
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */



public class Solution {




    public int removeDuplicates(int[] nums) {
        int k=nums[0];//当前数值
        int flag=1;//当前的下标
        int m=1;//两个就归零
        for (int i = 1; i < nums.length; i++) {
            if(m!=2)
            {
                if (k==nums[i])
                {
                    nums[flag]=nums[i];
                    flag++;
                    m++;
                }
                else
                {
                    nums[flag]=nums[i];
                    flag++;
                    m=1;
                    k=nums[i];
                }
            }
            else if(nums[i]==k)
            {
                k=nums[i];
            }
            else if(nums[i]!=k)
            {    k=nums[i];
                nums[flag]=nums[i];
                flag++;
                m=1;
            }


        }

        //看变种 80
       /* for (int i = 0; i < nums.length; i++) {
            if(k!=nums[i])
            {

                nums[flag]=nums[i];
                k=nums[i];
                flag++;
            }
        }
        for (int i = 0; i < flag; i++) {
            System.out.println(nums[i]);
        }*/
        return flag;
    }



    public static void main(String[] args) {


    }
}



