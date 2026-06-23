package com.practice.algorithm.leetcode.Hot100.medium.p215_findKthLargest;

import java.util.Random;

public class First {

	/*public int findKthLargest(int[] nums, int k) {
		//第一次复刻--说实话有点不太理解了
		//我记得是快排的思想演变,但是是新的算法思路
		//我真忘了,时间复杂度保持在o(n)--很难想
		//

	}*/

	public static void swap(int []nums,int left,int right ){
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

	public int findKthLargest(int[] nums, int k) {

		//关键就是o(n)的复杂度
		//还是不理解为什么是这个复杂度
		int l=0;
		int r=nums.length;
		while (l<r){
			//这个我记得是随机选取,不然复杂度会有问题,但是我忘了怎么做了具体
			int target=l;
//			while (nums[r]>=nums[l]){
//				r--;
//			}
//			swap(nums,l,r);
//			//这个while循环还有意义吗?因为和前面的while一样啊,不是这么做的,我想起来了
//			while (nums[r]nums[l])
			swap(nums,target,r);
			//值换到后面了--下标也要换
			int m=r;
			while (nums[r]>=nums[m]){
				r--;
			}
			while (nums[l]<nums[m]){
				l++;
			}
			swap(nums,l,r);
			//这样就会得到一种状态---左边小于等于 右边大于---怪不得要放到后面target,不然会混淆target位置
			//应该无所谓吧--等于放在哪一边都行的吧--交换的情况了
			//这样的话继续走的话--不就o(n)了吗?还没走完呢--l=r的时候,才行吧,然后比较此时位置和k,这样不就超过o(n)了吗复杂度

		}



	}

}
