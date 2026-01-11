package com.practice.algorithm.leetcode.Hot100.hard.p76_minWindow;

import java.util.HashMap;

public class Solution {


    public String minWindow(String s, String t) {

        String str="";
        // 这个是真不会---目前思路是通过哈希去找---但是最小怎么处理？---不行，不能用哈希，有重复字母--应该可以，加1
      /*  HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else {
                map.put(t.charAt(i),1);
            }
        }*/
        //重点是匹配啊
        int start=0,end=0;//首尾
        //可以remove这样来找----新的话就从第二个开始---但是怎么加入呢--换句话来说怎么找最小的？
        String str1=t;
        for (int i = 0; i < s.length(); i++) {
            if(str1.contains(String.valueOf(s.charAt(i)))){

            }
        }

        return str;
    }

    public static void main(String[] args) {

    }

}
