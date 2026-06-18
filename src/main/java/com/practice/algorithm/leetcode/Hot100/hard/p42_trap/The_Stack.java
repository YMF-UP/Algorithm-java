package com.practice.algorithm.leetcode.Hot100.hard.p42_trap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class The_Stack {

    /* public static int trap(int[] height){
        int sum=0;
       *//*
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
        }*//*
        Stack<Integer> k=new Stack<Integer>();
        //动态维护
        k.push(0);
        //从大到小怎么排
        for (int i = 1; i < height.length; i++) {
            //每次都要排序？
            if (k.size()>=2) {
                int m=k.get(k.size()-1);
                //不对，也要排序的吧----又是循环吗？
                if(height[i]> height[m]){
                }else {
                    k.push(i);
                }
            }else {
                if(height[i]>=height[k.get(0)]){
                    int m=k.pop();
                    k.push(i);
                    k.push(m);
                }else {
                    k.push(i);
                }
            }
        }
        return  sum;
    }*/

    public static int trap(int[] height) {

        //我想用单调栈试一下能不能做出来--毕竟做了84之后
        //也是左右端点--右端点就是第一个大于等于的,但是需要左边作为被减数
        Deque<Integer> s=new ArrayDeque<>();
        int cur=0;
        int sum=0;
        for (int i=0;i<=height.length;i++){

            while (!s.isEmpty()&&height[i]>=height[cur]){
                //还有一个问题就是cur怎么更新?
                sum+=height[cur]-s.pop();
            }
            s.push(height[i]);

        }

      return sum;
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
