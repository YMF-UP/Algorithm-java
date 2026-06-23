package com.practice.algorithm.leetcode.Hot100.easy.p118_generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//	public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ans=new ArrayList<>();
//		//这个是dp吗?--怎么使用dp呢?
//		//dp在这里面起到什么作用或者说符合dp的特性有哪些?---要看前面的状态,依赖前面的状态
//		//似乎只有这一个
//		List<Integer>path=new ArrayList<>();
//		//纯暴力吗?
//		for (int i = 1; i <= numRows; i++) {
//			for (int j = 1; j <= i; j++) {
//				if(j==1||j==i){
//					path.add(1);
//				}
//				//需要上面的,但是语法怎么写:还是我想的就不对
//				//上一层前一个后一个---这和dp有什么关系吗?啊这,我没想到
//			}
//
//			ans.add(new ArrayList<>(path));
//		}
//
//		return ans;
//	}

	public List<List<Integer>> generate(int numRows) {

		//语法还有具体数据结构也是需要注意的--也是我现在欠缺的
		//怎么首尾置一呢?这个好像有点难?--还是我对语法不熟悉
		//先全置一然后再修改
		/*for (int i = 0; i < numRows; i++) {
			List<Integer> path =new ArrayList<>();
			//这个怎么用来着,就全置一,i个大小
		}*/
		List<List<Integer>> ans=new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> path =new ArrayList<>();
			for (int j = 0; j <=i ; j++) {
				if(j==0||j==i){
					path.add(1);
				}else {
					path.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
				}
			}
			ans.add(new ArrayList<>(path));
		}
      return ans;

	}

}
