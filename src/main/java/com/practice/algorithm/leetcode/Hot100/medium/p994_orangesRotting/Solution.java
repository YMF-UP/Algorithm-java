package com.practice.algorithm.leetcode.Hot100.medium.p994_orangesRotting;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode 944.
 * 题目描述:1.有意思啊,上一题的变种了
 * 示例:
 * 解题思路:
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	/*private int dfs(int [][] grid,int time,int i,int j){
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
*/

	public int orangesRotting(int[][] grid) {
		int countnum=0;
		int row=grid.length-1;
		int line=grid[0].length-1;
		Queue<int[]> queue=new ArrayDeque<>();
		//先统计坏橘子位置,方便一起去感染,作为第一层
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==2){
					queue.add(new int[]{i,j});
				}
				if(grid[i][j]==1){
					countnum++;//判断最终是否有空白无法到达的,厉害
				}
			}
		}
		//然后就是bfs了,但是怎么记时间呢?
		//bfs需要去单独写一个函数吗?
		//第一层全部出来完--然后算时间和感染数,随后第二层
		//一开始我还想着说怎么处理四个方向呢--原来是这样啊
		int time=0;
		int [][] direction=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
		while (countnum>0&&!queue.isEmpty()){
			//要有两个循环吗?
			int num=queue.size();//当前层有几个节点
			for (int i = 0; i < num; i++) {
				int [] cur=queue.poll();
				//开始走四方
				for (int j = 0; j < direction.length; j++) {
					int k=cur[0]+direction[j][0];
					int m=cur[1]+direction[j][1];
					//或还是并呢?
					if(k>=0&&k<=row&&m>=0&&m<=line&&grid[k][m]==1)
					{
						grid[k][m]=2;
						queue.add(new int[]{k,m});
						countnum--;
					}
				}
			}
             time++;
		}
		return countnum >0? -1:time;
	}
}
