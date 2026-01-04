package com.practice.algorithm.leetcode.Hot100.hard.p42_trap;

import java.util.Stack;

public class The_Stack {
    public static int trap(int[] height){
        int sum=0;
        //单调栈的原理是什么？---还是有点没搞懂---碰到大的---但是没有右max怎么动态调整--其实还移动小的
        //没错，只有大于的时候---那不对啊---7    6这样呢
        //怎么确认左右的max---单调栈的话
        Stack<Integer> k=new Stack<Integer>();
        k.push(height[0]);
        for (int i = 1; i < height.length; i++) {
            if(k.get(0)>=height[i]){
                k.push(height[i]);
            } else if (k.size()>2) {
                sum+=Math.min(k.get(0),height[i]);
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int [] nu={5,4,1,2};
        int m=trap(nu);
        System.out.println(m);
        /*模拟了一下
        Stack<Integer> k=new Stack<>();
        for (int i = 0; i < nu.length; i++) {
            k.push(nu[i]);
        }
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i));
        }*/
    }



}
