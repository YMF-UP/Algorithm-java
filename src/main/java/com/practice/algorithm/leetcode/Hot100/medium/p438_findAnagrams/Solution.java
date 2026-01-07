package com.practice.algorithm.leetcode.Hot100.medium.p438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<Integer> findAnagrams(String s, String p) {
///          这个是有一点蠢或者说时间太复杂
//        List<Integer> list=new ArrayList<>();
//        //感觉就像之前那个哈希，找异位词的题目。就是先排序p，再依次寻找
//        char []chars=p.toCharArray();
//        Arrays.sort(chars);
//        String base=new String(chars);
//        for (int i = 0; i <= s.length()-p.length(); i++) {
//            String k=s.substring(i,i+p.length());
//            char[] chars1=k.toCharArray();
//            Arrays.sort(chars1);
//            String line=new String(chars1);
//            if(base.equals(line)){
//                list.add(i);
//            }
//        }
//        return list;

        //用排序了--自然可以用字母表了---char数组什么意思来着
        List<Integer> list=new ArrayList<>();

        char[] charsp=new char[26];
        for (int i = 0; i <p.length(); i++) {
            charsp[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char[] chars=new char[26];
            for(int j=0;j<p.length()&&(i+j)<s.length();j++)
            {
                chars[s.charAt(i+j)-'a']++;
            }
            if(Arrays.equals(chars,charsp)){
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        String s="cbaebabacd";
        String p= "abc";
        List<Integer> list=findAnagrams(s,p);
    }
}
