package com.practice.algorithm.leetcode.Hot100.medium.p200_numIslands;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * LeetCode 200. 岛屿
 * 题目描述: 1.图论--说实话真不怎么记得了
 * 示例:
 * 解题思路:
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */

public class Solution {

	private static void dfs(char[][] grid,int i,int j){
		//走到尽头的时候或者为0的时候就退出
		//问题是怎么判断是否孤立啊,也就是怎么最终加一啊
		//这个就是终止条件
		if(j==grid[0].length||i==grid.length||i<0||j<0){
			return;
		}
		if(grid[i][j]!='1')
		{
			return;
		}
		grid[i][j]='2';
		dfs(grid,i-1,j);
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
		dfs(grid,i+1,j);

	}

	public int numIslands(char[][] grid) {
         //本质就是更新状态,bfs--dfs应该也可以
		 //问题的关键就在于如何判断独立岛屿---通过判断吗?
		int [][] index=new int[grid.length][grid[0].length];//判断是否走过?--毕竟需要全部排查一下
		int sum=0;
		//bfs感觉可以,毕竟有个队列可以进行判断岛屿有没有走完---为1的进来,最后判断队列是否为空
		//只判断右边和下边一位就可以了--但是因为不是链表,需要进位置吗?---好像放不了位置啊,前后分别,一个放行,一个放列位置
		Deque<Character> deque=new ArrayDeque<>();
		//dfs吧应该,bfs还是不太熟练处理这个,应该是要递归

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				//右边和下边即可,首先要判断是不是然后往下走吗
				//不对,这样可能会漏啊---不一定,如果按照是否走过的话的话也可以,会漏一种情况的
				if(grid[i][j]=='1')
				{
					dfs(grid,i,j);
					sum+=1;
				}
			}
		}
		return sum;
	}
}
