package com.practice.algorithm.leetcode.Hot100.medium.p56_merge;

import java.util.Arrays;

public class Solution {

    public static int[][] merge(int[][] intervals) {
           // 我能想到的就是纯遍历了---复杂度最差要n平方了
           // 优化点在于---怎么确定新来的在之前的区域里面,或者之前的在这个区域里面
        int row =intervals.length;
        int [] [] array=new int[row][2];
        int []flagMerge=new int[row];
        int index=0;
        boolean merged=false;
        Arrays.fill(flagMerge,0);
        for (int i = 0; i< row; i++)
        {
            if(flagMerge[i]==0){
            //然后就是遍历了---遍历的是行不是列--先行后列
            for (int j = i+1; j <row ; j++) {
                // 是否在里面---怎么判断---要么大--要么小--总有交际
                //确定左右边界---判断是否有重叠区域
                //两种重叠方式--下交叉和上交叉
                if(flagMerge[j]==0){
//                  if(intervals[i][1]>=intervals[j][0]&&intervals[i][1]<=intervals[j][1]
//                          ||intervals[j][1]>=intervals[i][0]&&intervals[j][1]<=intervals[i][1])
//                              只要 区间i的左端点 <= 区间j的右端点，且 区间j的左端点 <= 区间i的右端点，就说明有重叠
           if(intervals[i][0] <= intervals[j][1] && intervals[j][0] <= intervals[i][1]){

                    intervals[i][0]=Math.min(intervals[i][0],intervals[j][0]);
                    intervals[i][1]=Math.max(intervals[i][1],intervals[j][1]);
                    flagMerge[j]=-1;
                    j=i;
                  }
              }
            }

            array[index][0]=intervals[i][0];
            array[index][1]=intervals[i][1];
            index++;
                flagMerge[i]=-1;

         }

        }

        return Arrays.copyOf(array, index);


       /* class Solution {
            public int[][] merge(int[][] intervals) {
                if (intervals.length == 0) {
                    return new int[0][2];
                }
                Arrays.sort(intervals, new Comparator<int[]>() {
                    public int compare(int[] interval1, int[] interval2) {
                        return interval1[0] - interval2[0];
                    }
                });
                List<int[]> merged = new ArrayList<int[]>();
                for (int i = 0; i < intervals.length; ++i) {
                    int L = intervals[i][0], R = intervals[i][1];
                    if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                        merged.add(new int[]{L, R});
                    } else {
                        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                    }
                }
                return merged.toArray(new int[merged.size()][]);
            }
        }

        作者：力扣官方题解
        链接：https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }


    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        int [][] merge=merge(test);
    }

}
