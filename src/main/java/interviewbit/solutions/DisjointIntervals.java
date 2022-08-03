package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/disjoint-intervals/
 */

import java.util.Arrays;
import java.util.Comparator;

public class DisjointIntervals {

    public int solve(int[][] intervals){
        return new Solution().solve(intervals);
    }

    public static class Solution {
        public int solve(int[][] A) {
            if (A.length == 1){
                return 1;
            }

            Arrays.sort(A, Comparator.comparingInt(o -> o[1]));

            int disjointedSetCount = 1;

            int rightMost = A[0][1];

            for (int i=1;i<A.length;i++){
                if (A[i][0] > rightMost){
                    ++disjointedSetCount;
                    rightMost = A[i][1];
                }
            }



            return disjointedSetCount;
        }
    }

}
