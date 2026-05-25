package com.practice.algorithm.leetcode.Hot100.medium.p22_generateParenthesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    private static void dfs(List<String> ans,StringBuilder path,int n,int cur,Deque<Character>deque){
		//本质还是一个子集和排列,和17题差不多
	    //一个难点在于括号的匹配,也就是要用栈---好像没有必要,因为都是一样的括号
        if(path.length()==n*2){
			ans.add(new String(path));
			return;
        }
		//判断点就是放括号---放还是不放'('
	    //但是要覆盖path了啊---这个怎么操作,全部重置
	    //如果我选择放括号---就继续,不放的话--弹出然后增加回括号然后增加到path
	    //不行,弹出的话不行

    }
	public List<String> generateParenthesis(int n) {
		//说实话,这业务一个比一个抽象啊---这又是一个括号匹配和回溯
        //我还真挺无措的
        List<String> ans=new ArrayList<>();
		StringBuilder path=new StringBuilder();
		Deque<Character>deque=new ArrayDeque<>();
		dfs(ans,path,n,0,deque);
		return ans;
	}
}
