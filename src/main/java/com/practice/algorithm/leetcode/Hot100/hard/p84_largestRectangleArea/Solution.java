package com.practice.algorithm.leetcode.Hot100.hard.p84_largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

	/*public int largestRectangleArea(int[] heights) {
		///  标签是栈,但说实话,我第一次看到这个题目联想不到栈这个思路---这也算是一个提醒了看来
		int max=0;
		//这一题怎么说呢?--好像之前的接雨水和最大面积一样
		//接雨水是很难的,其中用栈去做的方法我还真有点懵,dp和模拟---忘了怎么写的了,思路忘了
		//这个和最大面积还不太一样--中间可以为空,这个中间不能为空
		//通过判断后面来的大小就完事儿了--但是要注意状态
		//后面大的就先计算,什么时候弹出呢?--碰见小的就弹出,因为没必要了,但是弹出重要吗?
		//重要的应该是面积大小吧--碰见小的和大于等于的两个状态--碰到小的,计算后弹出;碰到大的,就一直计算
		//我还是没理解栈的存在是为了什么?
		//要维护两个栈吗?
		//来了一个大于的,就计算,怎么计算呢?用什么计算--循环吗?要记录宽度啊因为,for--但是不能弹出啊,接下来肯还会有啊
		Deque<Integer> deque=new ArrayDeque<>();
		for (int i = 0; i < heights.length; i++) {
			int k=0;
			while (!deque.isEmpty()&&)
		}

        return max;
	}
*/

//	public int largestRectangleArea(int[] heights) {
//		int max=0;
//		//是为了存一下当前的状态,没有确定左右边界之前
//		Deque<Integer> deque=new ArrayDeque<>();
//		int n=heights.length;
//		//三次遍历就好理解,往后的演变还是有点困难,我还是想搞懂一下,所以我想先写一下二次遍历
//
//		for (int i = 0; i < n; i++) {
//			int h=heights[i];
//			//大于等于的时候就出现边界了---这个是哪个边界?--第一个初始怎么判断
//			while (!deque.isEmpty()&&heights[deque.peek()]>=h){
//				//左边界变成peek()-1,有边界变成i.为什么呢?
//				//因为peek()前面那一个肯定是小于它的,不然就弹出了,右边界的话就是正常的这个
//				//但是初始第一个怎么搞?--先弹进去0下标吗?--不行吧--不会了
//
//			}
//			deque.push(i);
//		}
//
//		return max;
//	}

/*	public int largestRectangleArea(int[] heights) {

		//单调栈--还是需要去模拟思考一下,之前我已经思考出来一部分了,然后现在看过题解也是有点模糊
		//先想一下简单的吧,难的我还真不会
		//好像简单的我也有点问题啊,单调栈这个
		//本质就是找左右端点---右端点好找,小于的,但是怎么确定最大呢?左端点怎么找?
		//看来还是写不出来了--各种边界,好牛

	}*/

	/**public int largestRectangleArea(int[] heights) {

		Deque<Integer> deque=new ArrayDeque<>();
		int n=heights.length;
		int[] left=new int[n];
		int[] right=new int[n];
		Arrays.fill(right,n);
		for (int i = 0; i < n; i++) {
			int h=heights[i];
			while (!deque.isEmpty()&&heights[deque.peek()]>=h){
				//这个是为什么?---或者说这么写对吗?右边一直是i吗?对的如果大的话直接就出来了
				right[deque.pop()]=i;
			}
			left[i]=deque.isEmpty() ? -1 :deque.peek();
			deque.push(i);
		}
		int max=0;
		for (int i = 0; i < n; i++) {
			max=Math.max((right[i]-left[i]-1)*heights[i],max);
		}
		return max;

	}*/

	public int largestRectangleArea(int[] heights) {

		//想想怎么用一次遍历去做
		//本质就是左右边界或者说端点
		//二次遍历是计算端点和最后的值
		//我能想起来--就是背下来了
		Deque<Integer> deque=new ArrayDeque<>();
		deque.push(-1);
		int n=heights.length;
		int right;
		int[] left=new int [n];
//		Arrays.fill(right,n);
		for (int i = 0; i <= n; i++) {
			int h=i==n ? -1 :heights[i];
			//右端点不管怎么看都是遇到小于等于的,怎么退化呢?
			//二次遍历之所以做不到就是right和left同一个节点下的左右端点不同步--要怎么解决呢?
			//能很容易得到右端点,但是左端点怎么立刻得到--左端点就是第一个小它的
			//模拟一下--如果一直变大,左端点就是-1了,如果变小再变大左端点已经记录过了
			while (heights[deque.peek()]>=h){
				deque.pop();
				right=i;

			}
			left[i]=deque.peek();
			deque.push(i);

		}



	}

}
