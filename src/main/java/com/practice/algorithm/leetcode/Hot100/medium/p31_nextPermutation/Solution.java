package com.practice.algorithm.leetcode.Hot100.medium.p31_nextPermutation;

public class Solution {


	/**public void nextPermutation(int[] nums) {
		//这个之前写过也看过,但是有点太难了,就放弃了说实话,就很复杂我记得,我现在复刻也不行,只能试一试了
        //就是找目前这个排列的下一个大于它的序列,最大就返回最小
		//从后往前找到第一个小于前一个的,然后开始交换---是全部交换,把后面的全部交换到前面

		//从后往前找--重点是交换啊
		for (int i = nums.length-1; i >0; i--) {
			if(nums[i]>nums[i-1]){
				//开始交换--不对不对,应该是交换给第一个大于的那个位置,这要怎么记录呢?--而且还必须常数个空间
			}
		}
	}*/

	public void nextPermutation(int[] nums) {

		//看一遍题解就能记得的
		//从后向前--找到第一个大于前面的,然后交换,再然后后面的整体交换一下
		//没有找到就全部翻转
		if(nums.length==1){
			return;
		}
       int flag=0;
		for (int i = nums.length-1; i >0 ; i--) {

			if(nums[i]>nums[i-1]){
				//开始交换
				swap(nums,i,i-1);
				//后面的开始全面翻转
				of(nums,i,nums.length-1);
				flag=1;
				break;
			}
		}
		if(flag==0){
			of(nums,0,nums.length-1);
		}
	}

	public void swap(int []nums,int left,int right ){
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

	public void of(int []nums,int left,int right ){

		while (left<right){
			swap(nums,left,right);
			left++;
			right--;
		}

	}

}
