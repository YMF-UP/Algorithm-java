package com.practice.algorithm.leetcode.Hot100.medium.p17_letterCombinations;


import java.util.ArrayList;
import java.util.List;

public class Solution {


	/*//先写一下39啊--等会儿再写17

	private  static String getletter(char s){
		//写完全部的情况
		switch (s){
			case '2':return "abc";
			default:return "";
		}
	}
	private  static void dfs(List<String> ans,String path,String digits,int cur,int start){
		//这个必须是组合,不是单独的46和78的情况
		if(cur==digits.length()){
            ans.add(path);
			return;
		}
		for (int i = cur; i <digits.length() ; i++) {
			//第二个循环---需要一个boolen数组吗?
			char n=digits.charAt(i);//当前数字
			String now=getletter(n);
			for (int j = start; j < now.length(); j++) {
				dfs(ans,path+now.charAt(j),digits,0,0);
			}
		}
	}
	public List<String> letterCombinations(String digits) {
		List<String> ans=new ArrayList<>();
		//其实这个还蛮有意思的---本质还是一个子集全排列,也要抽象为一个多维树
		//抽象为多维树,这个像是结合了46题和78题
		//问题的关键在于如何抽象出来---相当于是两个数组和循环,第一个是digits--第二个是数字里面对应的那三个字符
		//感觉78题可以作为这一系列的母题了
		String path=new String();
		dfs(ans,path,digits,0,0);
		return ans;
	}
	*/
    private static final String[] letter={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	private  static void dfs(List<String> ans,String path,String digits,int cur,int n){
		//其实就是一个全排列
		//格式问题,我想一下啊.
		if(cur==n){
			ans.add(path);
			return;
		}
		int k=digits.charAt(cur)-'0';
		char[] s=letter[k].toCharArray();
		for (char i:s){
			//String里面怎么放char啊
			dfs(ans,path+i,digits,cur+1,n);
            //怎么去除呢?
		}
	}
	public List<String> letterCombinations(String digits) {
		int n=digits.length();
		List<String> ans=new ArrayList<>();
		//其实这个还蛮有意思的---本质还是一个子集全排列,也要抽象为一个多维树
		//抽象为多维树,这个像是结合了46题和78题
		//问题的关键在于如何抽象出来---相当于是两个数组和循环,第一个是digits--第二个是数字里面对应的那三个字符
		//感觉78题可以作为这一系列的母题了
		String path=new String();
		dfs(ans,path,digits,0,n);
		return ans;
	}




}
