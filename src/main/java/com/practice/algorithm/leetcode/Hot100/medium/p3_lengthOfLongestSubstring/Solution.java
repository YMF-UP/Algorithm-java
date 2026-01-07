package com.practice.algorithm.leetcode.Hot100.medium.p3_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

        public static  int lengthOfLongestSubstring(String s) {
//            if(s.length()==0)
//                return 0;
//            int length=1;
//           /* 整理一下思路---第一反应是kmp类似
//             * 1.就移动吧--不一样的就增大然后去找--但是问题是怎么知道最大的在哪里呢？
//             * 2.应该是可以的---一定有最大的
//             * 2.1先判断--递增去做---如果匹配上了--就以最新的开始进行匹配---没匹配上就加入变大
//             * 2.2那是用string还是char呢
//             * 3.一个一个加吗？---也不对--对，就是不重复的 */
//            String str=s.substring(0,1);
//            HashMap<String,Integer> map=new HashMap<String, Integer>();
//            map.put(str,0);
//            int flag=1;
//            for (int i = 1; i < s.length(); i++) {
//                String str1=s.substring(i,i+1);
//                if(map.containsKey(str1)){
//                    int m=map.get(str1);
//                    //就出在这里
//                    map.clear();
//                    i=m;
//                    if(length>flag){
//                        flag=length;
//                    }
//                    length=0;
//                }else {
//                    map.put(str1,i);
//                    length++;
//                }
//
//            }
//            if(length>flag){
//                flag=length;
//            }
//            /*
//              int index=1;
//              while ((index+length)<s.length()){
//                String str1=s.substring(index,index+length);
//                if(str.equals(str1)){
//                    index+=length;
//                }else {
//                    str+=str1;
//                    index+=length;
//                    length+=length;
//                }
//
//            }*/
//            return flag;


            int length=0;
            int left=-1;
            HashMap<Character,Integer> map=new HashMap<>();
            char [] chars=s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(map.containsKey(chars[i])){
                    //问题就出在这里---我当时想的是clear--然后重新再处理---这样太慢了
                    ///  关键点在这里----看了题解才知道---不是这里---是left--同时初始化也有问题
                 left=Math.max(left,map.get(chars[i]));
                }
                length=Math.max(length,i-left);
                map.put(chars[i],i);
            }
        return length;


/*
            Map<Character, Integer> dic = new HashMap<>();
            int i = -1, res = 0, len = s.length();
            for(int j = 0; j < len; j++) {
                if (dic.containsKey(s.charAt(j)))
                    i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
                dic.put(s.charAt(j), j); // 哈希表记录
                res = Math.max(res, j - i); // 更新结果
            }
            return res;


    作者：Krahets
    链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/2361797/3-wu-zhong-fu-zi-fu-de-zui-chang-zi-chua-26i5/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */



/*
            /// 这是标准解法---我少了什么呢？---重复计算了---每次都从头开始---优化的话，我在想一下
            /// 关键点在于
            if(s.length()==0)
              return 0;
            int left=0;
            int length=1;
            HashSet<Character> set=new HashSet<>();
            set.add(s.charAt(0));
            for (int right = 0; right < s.length(); right++) {
                if(right+1<s.length()&&set.contains(s.charAt(right+1))){
                    length=Math.max(length,right-left+1);
                   while (set.contains(s.charAt(right+1))){
                    set.remove(s.charAt(left));
                    left++;
                   }
                }
                length=Math.max(length,right-left+1);
                if(right+1<s.length()){
                     set.add(s.charAt(right+1));
                }
            }
            return length;*/

          /*  这才是标准思路啊---也就是我想一直做的，麻了
             int left = 0, maxLen = 0;
            Set<Character> set = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                while (set.contains(s.charAt(right))) {  // 当前字符重复
                    set.remove(s.charAt(left));          // 收缩窗口
                    left++;
                }
                set.add(s.charAt(right));                // 扩展窗口
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;*/


        }

/*    ***官方题解***
     class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/227999/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



    public static void main(String[] args) {
        String s="abcabcabc";
        int m=lengthOfLongestSubstring(s);
    }
}
