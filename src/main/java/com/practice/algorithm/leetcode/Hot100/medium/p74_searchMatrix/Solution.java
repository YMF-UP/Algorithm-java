package com.practice.algorithm.leetcode.Hot100.medium.p74_searchMatrix;

public class Solution {

    private static boolean search(int []nums,int target){
	    //怎么返回来着
	    int left=0;
	    int right=nums.length-1;
	    int mid;
	    while (left<=right){
		    mid=(left+right)/2;
		    if(nums[mid]==target){
			    return true;
		    } else if (nums[mid] > target) {
			    right=mid-1;

		    }else {
			    left=mid+1;

		    }
	    }
		return false;
    }

	public boolean searchMatrix(int[][] matrix, int target) {
        //说实话,要不是我指导在这一个标签下写题,我根本不知道使用二分查找
		//二维怎么弱化为一维,不需要弱化,因为有限制,每行开头
		//一做这种题目,就想到了当时写线代,真是悲伤啊
		/*
		1.确定位于哪几行--通过递增和行开头
		2.最笨的方法就是每一行都二分寻找一下,与其说是最笨的,不如说是我能想到的了
		3.'每行的第一个整数大于前一行的最后一个整数。'这个条件怎么使用呢?
		 */
       for(int [] c:matrix){

		 if(search(c,target)){
			 return true;
		 }

       }


		return false;
	}

}
