package com.practice.algorithm.leetcode.Hot100.medium.p3_lengthOfLongestSubstring;

import java.util.HashMap;

public class Solution {

        public static  int lengthOfLongestSubstring(String s) {
            if(s.length()==0)
                return 0;
            int length=1;
            /*整理一下思路---第一反应是kmp类似
            * 1.就移动吧--不一样的就增大然后去找--但是问题是怎么知道最大的在哪里呢？
            * 2.应该是可以的---一定有最大的
            * 2.1先判断--递增去做---如果匹配上了--就以最新的开始进行匹配---没匹配上就加入变大
            * 2.2那是用string还是char呢
            * 3.一个一个加吗？---也不对--对，就是不重复的 */
            String str=s.substring(0,1);
            HashMap<String,Integer> map=new HashMap<String, Integer>();
            map.put(str,0);
            int flag=1;
            for (int i = 1; i < s.length(); i++) {
                String str1=s.substring(i,i+1);
                if(map.containsKey(str1)){
                    int m=map.get(str1);
                    i=m;
                    map.clear();
                    if(length>flag){
                        flag=length;
                    }
                    length=0;
                }else {
                    map.put(str1,i);
                    length++;
                }
            }
            if(length>flag){
                flag=length;
            }
           /* int index=1;
            while ((index+length)<s.length()){
                String str1=s.substring(index,index+length);
                if(str.equals(str1)){
                    index+=length;
                }else {
                    str+=str1;
                    index+=length;
                    length+=length;
                }

            }*/
            return flag;
        }

    public static void main(String[] args) {
        String s="abcabcbb";
        int m=lengthOfLongestSubstring(s);
    }
}
