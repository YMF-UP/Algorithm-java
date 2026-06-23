package com.practice.algorithm.leetcode.Hot100.easy.p70_climbStairs;

public class Solution {

//	private static int sum=0;
//	private static void dfs(int n,int k){
//		if(k>n){
//			return;
//		}
//		if(k==n){
//			sum++;
//			return;
//		}
//		dfs(n,k+1);
//		dfs(n,k+2);
//
//
//	}
//	public  static int climbStairs(int n) {
//
//		//回溯倒是很简单,但是dp我没什么思路
//		//背包问题吗?--不对,这个要统计啊,背包放不放,这个是走不走吗?但是还是要回头啊
//		//不知道为什么?--每个点都要判断要不要走1或者2,怎么统计啊不回溯的话
//		dfs(n,0);
//        return sum;
//	}
//
//	public static void main(String[] args) {
//		System.out.println(climbStairs(3));
//	}

	public int climbStairs(int n) {

		//这个确实算是比较思路简单的了
		//子问题--当前阶梯下有几种,这样不够清晰---走一步和走两步前一个和前两个分别代表一步和两步
		int[] f=new int[n+1];
		f[0]=f[1]=1;
		for (int i = 2; i <= n; i++) {
			f[i]=f[i-2]+f[i-1];
		}
        return f[n];
	}


}
