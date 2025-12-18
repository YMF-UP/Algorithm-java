package com.practice.algorithm.leetcode.easy.p169_majorityElement;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 169.变种229
 * 题目描述：
 * 示例：
 * 解题思路：怎么说呢，这是408里面的一个题，我看过题解，知道思路
 *         用一个flag进行遍历，当前数字就加一否则减一为零的时候就更改当前直至最后对应的.
 *         因为超过半数的一定不为0，且一定会大于剩余全加在一起的.
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 * 129的话，大于n/3的只可能出现一个，但这一个不一定比两个之和大，但一定比任意一个大。
 * 明白了，其实就是分三等分，如果有出现的，一定在分的三个组里面的任意一组里面是大于一半的。
 * 但关键点是在于不一定第一次能找到一个大于一半的组，所以就有一点麻烦。
 * 先分别遍历一下吗？每个组。然后找到对应的大于等于一半的了。然后再去遍历一遍其余的吗？
 */




public class Solution {

    public List<Integer> majorityElement(int[] nums) {
         int flag=nums[0];
         int k=0;
        List<Integer> major=new ArrayList<>();

         //确实简单了，现在看229，变种题目，有难度。
/**        for (int i = 0; i < nums.length; i++) {
//            if(flag==nums[i])
//            {
//                k++;
//            }
//            else
//            {
//                k--;
//                if(k==0)
//                {
//                    flag=nums[i];
//                    k=1;
//                }
//            }
//
//        }
 */

        return major;
    }

    public static void main(String[] args) {

    }
}
