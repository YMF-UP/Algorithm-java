package com.practice.algorithm.leetcode.easy.p1_twoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * LeetCode 1.
 * 题目描述：
 * 示例：
 * 解题思路：1.暴力就是双for呗
 *         2.用哈希的话，下标怎么得到啊？现在在考虑这个--直接value是下标.
 *         题解直接边走边判断，确实省了一个循环。key-value都是一样的
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */

public class Solution {




    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> f=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            f.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
           int m=target-nums[i];
           if(f.get(m)!=null&&f.get(m)!=i)
           {
               result[0]=i;
               result[1]=f.get(m);
               break;
           }
        }
        return result;
    }

    public static void main(String[] args) {


    }
}
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (hashtable.containsKey(target - nums[i])) {
//                return new int[]{hashtable.get(target - nums[i]), i};
//            }
//            hashtable.put(nums[i], i);
//        }
//        return new int[0];
//    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/two-sum/solutions/434597/liang-shu-zhi-he-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
