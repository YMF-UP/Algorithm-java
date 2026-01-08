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

        /// 看似理解了滑动窗口--其实还是没理解
//        //用排序了--自然可以用字母表了---char数组什么意思来着
//        List<Integer> list=new ArrayList<>();
//        char[] charsp=new char[26];
//        for (int i = 0; i <p.length(); i++) {
//            charsp[p.charAt(i)-'a']++;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char[] chars=new char[26];
//            for(int j=0;j<p.length()&&(i+j)<s.length();j++)
//            {
//                chars[s.charAt(i+j)-'a']++;
//            }
//            if(Arrays.equals(chars,charsp)){
//                list.add(i);
//            }
//        }
//        return list;


       /* 很巧妙啊
         List<Integer> list=new ArrayList<>();
        char[] charsp=new char[26];
        for (int i = 0; i < p.length(); i++) {
            charsp[p.charAt(i)-'a']++;
        }
        char[] chars =new char[26];
        int left=0;//左
        for (int i = 0; i < s.length(); i++) {
              chars[s.charAt(i)-'a']++;
              if(i-left+1==p.length()){
                  if(Arrays.equals(chars,charsp)){
                      list.add(left);
                  }
                  chars[s.charAt(left)-'a']--;
                  left++;
              }
        }
        return list;
        */


       /// 题解的优化算法，我怎么看不懂呢？----不知道优化在哪里了？也需要维护两个数组吧
        /* List<Integer> list=new ArrayList<>();
        char[] charsp=new char[26];
        for (int i = 0; i < p.length(); i++) {
            charsp[p.charAt(i)-'a']++;
        }
        char[] chars =new char[26];
        int differ=p.length();
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
            if(chars[s.charAt(i)-'a']== charsp[s.charAt(i)-'a']){

            }

        }

        return list;*/

        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;

    }


    public static void main(String[] args) {

        String s="aaaebabacd";
        String p= "abc";
        List<Integer> list=findAnagrams(s,p);
    }
}
