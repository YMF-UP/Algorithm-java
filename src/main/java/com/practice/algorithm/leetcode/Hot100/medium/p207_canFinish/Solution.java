package com.practice.algorithm.leetcode.Hot100.medium.p207_canFinish;


import java.util.Arrays;

/**
 * LeetCode .
 * 题目描述:
 * 示例:
 * 解题思路:1.突然就想到了22年考研的时候的学习,最小生成树,看来也在一直帮助我啊--那我更不能辜负了啊
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Solution {

	private static int find(int []rank,int i){

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
	}
}
