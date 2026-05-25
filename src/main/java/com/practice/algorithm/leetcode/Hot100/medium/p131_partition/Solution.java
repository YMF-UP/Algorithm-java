package com.practice.algorithm.leetcode.Hot100.medium.p131_partition;

import jdk.internal.joptsimple.internal.Strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static void dfs(List<List<String>> ans, List<String> path, String s, int num){
		String original = path.toString();
		String reversed = new StringBuilder(original).reverse().toString();
		if (original.equals(reversed)) {
			// 是回文
			ans.add(new ArrayList<>(path));
			return;
		}

		//子串就意味着是顺序的
		for (int i = num; i < s.length(); i++) {
			path.add();
			dfs(ans,path,s,i+1);

		}
	}

	public List<List<String>> partition(String s) {

		//其实我有点不太理解为什么要分开,直接一个不好了吗?
		List<List<String>> ans=new ArrayList<>();
		List<String> path=new ArrayList<>();
		dfs(ans,path,s,0);
        return ans;
	}

}
