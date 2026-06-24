package com.practice.algorithm.leetcode.Hot100.hard.p32_longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

//	public int longestValidParentheses(String s) {
//		//这个要求子串最大,不是用栈吗?--栈做不了子串的问题
//		//字串那就是要求是连续的啊---合法的子串,只要合法就行,那dp记录什么?
//		//我要记录什么状态
//	}

	public int longestValidParentheses(String s) {
		//我想一下---只记得做法但不记得为什么了?
		//左右括号的个数--相等不必说
		//左大于右的时候---直接右个数不行吗?--我记得题解是要翻转一下,为什么?
		//右大于左的时候就归零重新计算

		//只按照栈呢?--记录下标呗
		Deque<Integer> deque=new ArrayDeque<>();
		char [] c=s.toCharArray();
		//要算字串--所以
		boolean [] f=new boolean[s.length()];
		for (int i = 0; i < c.length; i++) {
			if(c[i]=='('){
				deque.push(i);
			}else {
				if(!deque.isEmpty()){
					f[deque.pop()]=true;
                    f[i]=true;
				}
			}
		}
        int max=0;
		int k=0;
		for (int i = 0; i < f.length; i++) {
			if(f[i]){
				k++;
				max=Math.max(max,k);
			}else {
				k=0;
			}
		}
        return max;
	}

}
