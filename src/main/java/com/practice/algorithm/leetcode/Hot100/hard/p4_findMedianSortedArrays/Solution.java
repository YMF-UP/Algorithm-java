package com.practice.algorithm.leetcode.Hot100.hard.p4_findMedianSortedArrays;

public class Solution {

	/// 这个确实难啊,或者说这个就是408里面的,为啥那么我还记得啊,肯记忆太深刻了吧,当时的学习太刻苦了
	/// 突然间又想到考研的事情了,确实不甘心啊,现在就是不甘心了.
	/*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//我现在回忆起来的就是怎么说呢---能想起来怎么做
		//但是终止条件是什么呢?--这个确实
		//模拟一下的话---一直二分:大的去小的里面,小的去大的里面找
		// 二分吗?不是,就是找中间数值
		//双闭好像不太行,左闭右开呢?---还是双开
		int m=nums1.length;
		int n=nums2.length;
        int l1=0,r1=nums1.length;
		int l2=0,r2=nums2.length;
		while (l1<r1&&l2<r2){
			int mid1=l1+(r1-l1)/2;
			int mid2=l2+(r2-l2)/2;
			if(nums1[mid1]==nums2[mid2]){
				r1=mid1;
				r2=mid2;
				break;
			}else if(nums1[mid1]>nums2[mid2]){
                r1=mid1;
				l2=mid2+1;
            }else {
				r2=mid2;
				l1=mid1+1;
            }
		}
        //现在就是得到了
		//分一下奇偶--如果奇数就只有一个,如果是偶数就是两个
		//但如果是奇数的话,是哪一个呢?现在是分别得到了
		if((m+n)/2==0){

		}else {

		}
	}*/


		//我试一下我的记忆怎么样--之前就是记住了,但不一定是完全理解和记忆的状态
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {

			int m=nums1.length;
			int n=nums2.length;
//			int curMid=Math.max(m,n);
			//一个是从头到尾,一个是从尾到头,不断的改变区间数量
			//但是大小怎么判断,偶数个和奇数个还是不一样的
			//无论偶还是奇数--
			int set1=(m+n+1)/2;
			int set2=set1;
			int i=0;
			while (true){
				//一个增一个减,但是得考虑数量啊
				//还有一个点就是两个数组的大小
				//还有一种就是边界,不太对啊这个
				 while (nums2[--n]>nums1[i++]&&set2!=0){
					 set2--;
				}



			}




		}






}
