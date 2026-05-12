package com.practice.algorithm.leetcode.Hot100.medium.p207_canFinish;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode .
 * 题目描述:
 * 示例:
 * 解题思路:1.突然就想到了22年考研的时候的学习,最小生成树,看来也在一直帮助我啊--那我更不能辜负了啊
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	/*private static int find(int []rank,int i){

       if(find(rank,rank[i])==i){
		return i;
	   }
	   return -1;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//能想到是最小生成树,但是这个是有向图的,会不一样了感觉
	    //只需要判断能不能成环就行了好像,这样也可以看作是无向图,不敢确实是有方向
		//克鲁斯卡尔和普利姆算法
		//普利姆更难---先尝试一下克鲁斯卡尔
        //有意思,不是完全的模板题
		/// 难点在于:a和b不是按顺序出现的,如果前面出现[2,5],直到很后面才出现也无所谓
		//就直接找就行了,也是秩排序,低于的肯定不行吧,秩直接判断了,主要还是有没有环出现
		int rank[]=new int[2000];
		Arrays.fill(rank,-1);
		for(int [] cur:prerequisites){
			int a=cur[0];
			int b=cur[1];
			//判断能不能成环---也就是rank是否低于当前的,那初始化呢?---前面的-1吗?/
			//本质上还是有向的啊,[2,5]和后面的[5,3],3天然就要比5高,但是前面按照这个逻辑,5肯定增高秩了
			//所以不能按照秩吗?只能按照链条那种?
			//先查找后更新这两步
			//怎么更新呢?
			//应该是先find吧,然后可以更新了,根据情况
			int fa=find(rank,a);
			int fb=find(rank,b);
			if(fa==-1&&fb==-1){
                rank[a]=b;
				rank[b]=b;
				numCourses-=2;
			}else if(fb==-1){
				rank[a]=b;
				rank[b]=b;
				numCourses-=1;
			} else if (a==fb) {
				return false;
			}
		}
       return true;
	}*/


    //dfs和bfs都是可以的
	//bfs是消减入度为
	//dfs----三色法,就是标记--不太会,先试着回忆一下题解写这一个

	// 怎么做
	private static boolean dfs(List<Integer>[] graph,int[] color, int be){
		color[be]=1;//正在
        for (int cur:graph[be]){
			//本质就还是寻找到了正在执行的,那为什么还需要2呢?
	        if(color[cur]==1||color[cur]==0&&dfs(graph,color,cur)){
				return true;//就还是说找到环了
	        }
        }
		//什么时候置2,怎么判断是不是环
		color[be]=2;//就是说这个既不是正在执行的,也不是以后可以执行的,排除掉
		return false;
	}


	public boolean canFinish(int numCourses, int[][] prerequisites) {
		///三色---为什么要引入一个第三色?

		//先写邻接表吧
		///List<int[]> graph=new ArrayList<>();//是这样吗?---相当于一个list类型里面是int数组--对吗?可以graph[i]吗?我这个有点不太懂了
		List<Integer>[] graph=new ArrayList[numCourses];//这个才对,list数组,为什么是numCourses?
		Arrays.setAll(graph,i->new ArrayList<>());
		for (int [] cur:prerequisites){
			int from=cur[1];
			int to=cur[0];
			graph[from].add(to);//有向---b指向a
		}
        //三色,0 1 2
		int [] color =new int[numCourses];
		Arrays.fill(color,0);
		//开始遍历对应的组合---究竟是graph还是prerequisites---
		for (int [] cur:prerequisites){
		     /// color[cur[1]]=1;//作为开始 //似乎不应该放在这里
			 //判断---怎能判断,去dfs它的指向,也就是深度递归这个方向
			//怎么是算有环呢,0-1 1-2 2-0,怎么dfs呢?
			 if(color[cur[1]]==0&&dfs(graph,color,cur[1])){
                   return false;
			 }
		}
		return true;
	}

}
