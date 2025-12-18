package com.practice.algorithm.leetcode.easy.p88_merge;



/**
 * LeetCode 88. 合并
 * 题目描述：
 * 示例：
 * 解题思路：1.算是回忆一下吧,两个数组能做到吗？除非就是插入了，后退，那时间复杂度有点高了快n平方了。三数组才可以吧
 *         2.双数组，其实就是位置，1里面的位置，就是交换，有点复杂，还是三个数组吧
 *         3.逆向，考虑大的，放到后面
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n)
    {  int []result=new int[m+n];
        int i=0,j=0,k=0;
        for (; i <m&&j<n; ) {
            if (nums1[i]>nums2[j]) {
               result[k++]=nums2[j];
               j++;
            }
            else{
                result[k++]=nums1[i];
                i++;
            }
        }
        while (i<m)
            result[k++]=nums1[i++];
        while (j<n)
            result[k++]=nums2[j++];
        for (int l = 0; l < m; l++) {
            nums1[l]=result[l];

        }

    }

    public static void main(String[] args) {

}
}
