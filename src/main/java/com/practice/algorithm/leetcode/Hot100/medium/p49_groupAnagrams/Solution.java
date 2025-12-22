package com.practice.algorithm.leetcode.Hot100.medium.p49_groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, List<String>> sm = new HashMap<>();
        ;
        //第一个循环就是为了把字符串放到对应的map中去
        for (String str : strs) {
            //其实还是要排序，不然没办法啊，要确定key值
            char[] s = str.toCharArray();
            Arrays.sort(s);//只能排char数组
            //排完之后就是要放到hash里面--要放到key和value啊
            // 但是初始化是null啊，缺了什么总感觉
            //感觉还是语法不熟悉
            /** 1.果然是直接获取了
             * */
            String m = s.toString();//这么写是错的，要去理解toString
             m=new String(s);//这是对的
            List<String> list = sm.getOrDefault(m, new ArrayList<>());
            list.add(str);
            sm.put(m, list);
          }
        return new ArrayList<List<String>>(sm.values());//这个也需要看一下，hashmap的语法了
            /*List<List<String>> res=new ArrayList<>();
             *//* 我看过题解，题解使用map<map>的形式来存储
           我先试着写一下啊，看过代码了，印象比较深刻
           hashmap是自动排序的---关键点--我记错了吗?
         *//*
        HashMap<String,List<String>> sm=new HashMap<>();;
        //第一个循环就是为了把字符串放到对应的map中去
        for (String str:strs){
           //其实还是要排序，不然没办法啊，要确定key值
            char [] s=str.toCharArray();
            Arrays.sort(s);//只能排char数组
            //排完之后就是要放到hash里面--要放到key和value啊
            // 但是初始化是null啊，缺了什么总感觉
            //感觉还是语法不熟悉
            *//** 1.果然是直接获取了
             * *//*
            String m=s.toString();
            List<String> list=sm.getOrDefault(m,new ArrayList<>());
            list.add(str);
            sm.put(m,list);
        }
        for(String str:strs){
            res.add(sm.get(str));
        }
        return res;*/


    }

    public static void main(String[] args) {
        String []SM={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> m=groupAnagrams(SM);

    }

}
