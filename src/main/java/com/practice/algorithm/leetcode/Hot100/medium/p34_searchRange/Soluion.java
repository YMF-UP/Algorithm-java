package com.practice.algorithm.leetcode.Hot100.medium.p34_searchRange;

public class Soluion {

	public int[] searchRange(int[] nums, int target) {
		//说实话,还真不会,不是单纯的找某一个了,而是找范围
		///好处是在于,是非递减的,只要找到第一个小于的以及第一个大于它的范围就行了 我觉着这个是重点
		//可是怎么确定是第一个呢?---还是说依然只找target
		int [] cur=new int[]{-1,-1};
        //范围肯定就不变啊
		//区间寻找是哪一个呢?分开做吗?
		if(nums.length==0){
			return cur;
		}
		int l1=0;
		int r1=nums.length-1;
		while (l1<=r1){
			int mid=l1+(r1-l1)/2;
			if(nums[mid]<target){
				l1=mid+1;
			} else  {
				r1=mid-1;
			}
		}
		if(l1<nums.length&&nums[l1]==target){
           cur[0]=l1;
		}
		//然后从这个范围开始去做就行了---这没什么逻辑思考啊,真是这样吗?
		//关键点就变成了找到第一个大于的位置,不能用闭区间了---左开右闭
		//这种都不对,因为无论哪一个都是找到第一个的,所以要反着来,找到第一个大于它的就行了
		r1=nums.length-1;
		while (l1<r1){
			int mid=(r1+l1+1)/2;
			if(nums[mid]<=target){
				l1=mid;
			} else  {
				r1=mid-1;
			}
		}
		if(nums[r1]==target){
            cur[1]=r1;
		}
		return cur;
	}
}
