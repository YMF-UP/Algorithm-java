package com.practice.utils;

public class Swap  {

    public void swap(int []nums,int left,int right ){
         int temp=nums[left];
         nums[left]=nums[right];
         nums[right]=temp;
    }

}
