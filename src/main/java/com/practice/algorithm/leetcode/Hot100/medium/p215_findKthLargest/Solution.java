package com.practice.algorithm.leetcode.Hot100.medium.p215_findKthLargest;




/**
 * LeetCode 215.
 * 题目描述：
 * 示例：
 * 解题思路：
 * 时间复杂度：O(...)
 * 空间复杂度：O(...)
 */


public class Solution {

    public int findKthLargest(int[] nums, int k) {
           int find=nums[0];
           //时间复杂度o(n),那就空间换时间
           //用k作为索引
           //贪心啊这是---每次确定一个
           //两个东西来确定---目前第几个大数;往上是多少
           //第一个东西---其实和k息息相关--小于k的时候无所谓---等于k的时候才需要引入第二个
           //第二个的话---就需要一个数组吗---但是需要排序啊--不需要,往上增就行了。---大根堆吗难道---但是时间复杂度超了
        int  flag=1;
        int  [] set=new int[k];//存储大的,最多k个
        set[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
                  if(flag<k){
                      if(find>nums[i]){
                          find=nums[i];
                      }
                      set[flag++]=nums[i];
                  }//小于k的时候把目前最小的作为find
                else {


                  }//等于k的时候如果出现大的,直接踢掉当前---但最关键的是顺序，两个倒还好，多个呢？
                   //其实就是踢掉之后如何确定当前的k---那还需要循环啊--需要最小的啊当前。比如说4、3、3、5、6、9、4.k=4---那还是需要当前顺序啊
                   //不会真是堆吧--可是排序的时间复杂度--O(n log n)--而且要真是小根堆那也太容易了
                   //把大的放到后面---小于但是大于当前flag的时候怎么办4、2、5、7 、3、6、9 k=4
                   //比如 6、4、5、7的时候，k=2
        }

           return  find;
    }

    public static void main(String[] args) {

    }
}
