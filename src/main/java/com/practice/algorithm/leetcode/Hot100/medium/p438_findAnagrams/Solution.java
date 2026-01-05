package com.practice.algorithm.leetcode.Hot100.medium.p438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        //感觉就像之前那个哈希，找异位词的题目。就是先排序p，再依次寻找
        char []chars=p.toCharArray();
        Arrays.sort(chars);
        String base=new String(chars);
        for (int i = 0; i <= s.length()-p.length(); i++) {
            String k=s.substring(i,i+p.length());
            char[] chars1=k.toCharArray();
            Arrays.sort(chars1);
            String line=new String(chars1);
            if(base.equals(line)){
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {

    }
}
