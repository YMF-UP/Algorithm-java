package com.practice.algorithm.leetcode.Hot100.medium.p139_wordBreak;

import java.util.List;

public class Solution {

	public boolean wordBreak(String s, List<String> wordDict) {
        //也是一个完全背包,但是这个是字符串,那就是怎么终结循环呢--之前是有范围
		//这个似乎更简单了,直接走一圈看看能不能匹配,和dp有关系吗?--这个就直接匹配,和之前状态有关系吗?
		int n=s.length();
		int i=0;
		int k=n;
		while (i<n){
            int flag=i;
			for (int j = 0; j < wordDict.size(); j++) {
				//开始匹配--怎么匹配呢?--就取吗?按照当前单词长度?那和dp有什么关系啊
				String cur=wordDict.get(j);
				if(cur.length()+i>s.length()){
					continue;
				}
				String c=s.substring(i,i+cur.length());
				if(c.equals(cur)){
					i+=cur.length();
					break;
				}
			}
            if(flag==i){
				return false;
            }
		}



		return true;
	}

}
