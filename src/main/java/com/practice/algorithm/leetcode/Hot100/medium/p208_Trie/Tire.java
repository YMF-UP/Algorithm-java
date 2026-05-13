package com.practice.algorithm.leetcode.Hot100.medium.p208_Trie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 208.构建前缀树
 * 题目描述:
 * 示例:
 * 解题思路:1.有点没思路,什么意思啊这是,前缀树和图
 *        2.前缀树和图又什么关系,那不是树吗
 *        3.这不就是增删改查吗?--歪日
 * 时间复杂度:O(...)
 * 空间复杂度:O(...)
 */


public class Tire {

    //这玩意之前学408的时候很简单的知识,但是真正去写出来代码还是差点意思
	//难道不需要其他的吗?--dfs之类的了.找前缀啊,不就是dfs遍历
	//多维树,一个父亲节点可能会有多个子节点


		//这个应该是创建一个图---但是从需求来看,好像又不是

        /// 确实没想到是直接穷举了26叉树形式
		/// 重点来讲就是树的初始化定义了
        /// 这个初始化定义我是真不太懂,还是不理解
		public  static class Node{
			Node []son=new Node[26];
			boolean end=false;
        }
        private  final Node root=new Node();


	public void insert(String word) {
        //怎么插入呢?---肯定要调用tire里面初始化的了
		/// 开始插入,通过与字符'a'相减确认,但是需要public定义的那个root数组
		Node cur=root;
        for (char c:word.toCharArray()){
			 int b=c-'a';
			 /*cur.son[b]=new Node();
			 cur.son[b].end=true;
             cur=cur.son[b];*/
	        if(cur.son[b]==null){
				cur.son[b]=new Node();
	        }
			cur=cur.son[b];
			cur.end=true;
        }
	}

	public boolean search(String word) {
         //dfs还是哈希
		 /// 都不是了--直接循环就行了--怪不得要一个布尔定义
		Node cur=root;
		for (char c:word.toCharArray()){
			int b=c-'a';
			if(!cur.son[b].end){
				return false;
			}
			cur=cur.son[b];
		}
		return true;
	}

	public boolean startsWith(String prefix) {
       //dfs
		/// 这个和前面那个search有什么区别吗?---终止条件的不同吗?不是吧
		return search(prefix);
	}
}
