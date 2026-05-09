package com.practice.algorithm.leetcode.Hot100.medium.p994_orangesRotting;



/**
 * LeetCode 944.
 * 题目描述:1.有意思啊,上一题的变种了
 * 示例:
 * 解题思路:
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	private int dfs(int [][] grid,int time,int i,int j){
		if(grid[i][j]==2){
			return time;
		}
		if(i>grid.length||i<0||j>grid[0].length||j<0){
			return time;
		}
		if(grid[i][j]==0){
			return time;
		}
		//有两个问题解决不了
		//1.怎么返回空岛
		//2.怎么把已经走过的剪枝掉---不会了目前,因为每一个都要走一遍我目前的思路.
		//我目前还是觉着只能这么做,time怎么改变呢?---就是如果真没有怎么返回零,也就是空岛
		//难道要先判断一下里面有没有坏橘子吗?---不会吧
		//卡住了
	}

	public int orangesRotting(int[][] grid) {
        //比较笨的方法就是先找腐烂的橘子,但是不一定时一个,要同时腐烂这个就有点困难
		//也就是说要找到最先坏的橘子的最近路径--这怎么找,因为在改变啊,无法确认是不是最近的了
		//那就反过来做,任意一个开始,开始计时,只要碰到就返回,然后在所有里面取时间最大值
		int max=-1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int maxTime=0;
				if(grid[i][j]==1){
					maxTime=dfs(grid,0,i,j);
				}
				if(maxTime==0){
					max=-1;
				} else if (maxTime > max) {
					max=maxTime;
				}
			}
		}
		return max;
	}


}
