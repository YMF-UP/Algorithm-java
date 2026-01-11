package com.practice.algorithm.leetcode.Hot100.hard.p76_minWindow;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public String minWindow(String s, String t) {

       /* String str="";
        // 这个是真不会---目前思路是通过哈希去找---但是最小怎么处理？---不行，不能用哈希，有重复字母--应该可以，加1
      *//*  HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else {
                map.put(t.charAt(i),1);
            }
        }*//*
        //重点是匹配啊
        int start=0,end=0;//首尾
        //可以remove这样来找----新的话就从第二个开始---但是怎么加入呢--换句话来说怎么找最小的？
        String str1=t;
        for (int i = 0; i < s.length(); i++) {
            if(str1.contains(String.valueOf(s.charAt(i)))){

            }
        }

        return str;*/

        /// 根据deepsek提供的思路复现一下---知道问题出在哪里了---没有深入去想--去想细节
        ///为什么感觉用char数组来写最好
       /* HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char m=t.charAt(i);
            if(need.containsKey(m)){
                int l=need.get(m);
                need.put(m,l+1);
            }else {
                need.put(m,1);
            }
        }
        int left=0,right=0;
        int differ=s.length();
        for ( right = 0; right < s.length(); right++) {
            char m=s.charAt(right);
            if(need.containsKey(m)){
                int l= window.getOrDefault(m,0);
                window.put(m,l+1);
                if(window.get(m)==need.get(m)){
                    differ--;

                }
            }

        }*/
        int differ=t.length();
        int minlen=Integer.MAX_VALUE;
        String min="";
        char [] need=new char[26];
        char [] window=new char[26];
        int [] flag=new int[s.length()];
        int index=0,j=0;
        /// 这两个是有问题的---好好想想
//        Arrays.fill(need,'0');
//        Arrays.fill(window,'0');
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left=0,right=0;
        while ( right< s.length()) {

             char m=s.charAt(right);
             right++;
             if(need[m]!='0'){
                 flag[index++]=right;
                 window[m]++;
             if(window[m]<=need[m]){
                 differ--;
               }
             }
             while (differ==0){
                 if(right-left<minlen){
                     minlen=right-left;
                     min=s.substring(left,right);
                 }
                 char k=s.charAt(left);
                 left=flag[j++];
                 //存在的时候怎么处理来着---判断是否合适
                 if(need[k]!=0){
                  if(window[k]==need[k]){
                     differ++;
                    }
                 }
                 window[k]--;
             }
        }
        return  min;

    }

    public static void main(String[] args) {

    }

}
