package com.practice.algorithm.leetcode.Hot100.hard.p42_trap;

public class Solution {

    public  static int trap(int[] height) {

        if(height.length<3)
            return  0;
        //最重要的是左右边界
        //双指针好像很简单啊---但是要遍历每一根柱子吗--还是区域重要
        //但是每一个都要遍历不就太复杂了吗---时间复杂度---怎么降低的呢？
        //好像有点懂了---左右边界为主---左右指针---只有小于左右边界才可以计算
        //到边界的时候怎么办---这个确实有点不知道怎么处理---也是继续寻找边界
        int left=0;
        int right=2;
        int sum=0;
        //突然感觉这个做法和之前一样了，哈哈--还是不对--但有点接近了感觉
        for (int i = 1; i < height.length-1; ) {
            while (i<=left)
                i++;
            while (right<=i)
                right++;
            //就还是边界问题
            if (height[i]<height[right]&&height[i]<height[left]){
               int h= Math.min(height[right],height[left]);
               sum+=h-height[i];
               i++;
            } else if (height[i]>=height[left]) {
                //移动呗
                while (i>left&&height[i]>=height[left]){
                    left++;
                }
            }else if(height[i]>=height[right]){
                while (i<=right&&height[i]>=height[right]){
                    if(right==height.length-1){
                        i++;
                        right=i+1;
                        break;
                    }
                    right++;
                }
            }
        }
     return  sum;


        /// 打补丁就是不行，但是看了一些思想也知道为什么不对了---先尝试写一下
//        //贪心啊像
//        //高低高---得有缝隙啊---得出现起伏
//        //结束点就是碰到高于它的---但是中间怎么记录---这个最重要了
//        //先试一下吧---一个循环就行了吗？
//        //次高作为高度---宽度另算---必须高低高---出现一次高低高就计算一次---怎么感觉是递归啊
//        //头尾两个肯定不对啊
//        if(height.length<3)
//            return  0;
//        int sum=0;
//           //0,1,0,2,1,0,1,3,2,1,2,1----debug了一下，有几个问题
//          //其实就一个问题---就是提前结束---在中间就结束了
//          //但是会死循环---只能先判定了---但是那样--时间复杂度
//        for ( int right=0;right<height.length-2;) {
////            if(height[right]==height[right-1]&&right>0)
////                continue;
////            if(height[right]==0)
////                continue;
//            int left = right+1;
//            int m=height[right];//起始高
//            //确定一个区域之后再具体计算吗？
//            int sum_b=0;
//            int wide=0;//宽
//            //在这里加一个判断---用来是否整体处理
//            //但是对于0,7,1,4,6这种就解决不了了
//            while (height[right] > height[left]){
//                sum_b+=height[left];//计算高度
//                left++;
//                wide++;
//                if(left==height.length){
//                    break;
//                }
//            }
//            if(left==height.length){
//                left--;
//            }
////            if(right==0&&left==height.length-1)
////                 return  0;
//            //缺少了判断两端，左大右边小的状况了--这个只能判断左小右大---因为我一直以为全大于的情况就要归为下面来处理了
//            if(m>height[left]){
//                 left = right+1;
//            }else  {
//                sum+=wide*m-sum_b;
//                right=left;
//            }
//            sum_b=0;
//            wide=0;
//            //里面太简单了---忽略了一些东西---连续的时候---也就是说这个只算间隔一个---因为前面已经判断多个的情况了
//            while (height[right] > height[left]) {
//                //更新次高吗？---不确定次高是多少
//                sum_b=height[left];//计算高度
//                right++;
//                left++;
//                wide=1;
//                if(left==height.length-1){
//                    break;
//                }
//            }
//            if(left==height.length){
//               left--;
//            }
//            //开始计算吗？---计算了
//            if(height[right-1]>=height[left]){
//                sum+=wide*height[left]-sum_b;
//            }else {
//                sum+=wide*height[right-1]-sum_b;
//            }
//            if(left!=height.length){
//                right=left;
//            }
//
//        }
//
//    return sum;
    }

    public static void main(String[] args) {
        int [] nu={0,1,0,2,1,0,1,3,2,1,2,1};
        int m=trap(nu);
        System.out.println(m);
    }

}
