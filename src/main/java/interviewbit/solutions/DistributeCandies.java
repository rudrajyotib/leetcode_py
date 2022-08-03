package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/distribute-candy/
 */

import java.util.Arrays;

public class DistributeCandies {

    public int solve(int[] ranks){
        return new Solution().candy(ranks);
    }

    public static class Solution {
        public int candy(int[] A) {
            int[] candies = new int[A.length];
            Arrays.fill(candies, 1);
            for (int i=1;i<A.length;i++){
                if (A[i] > A[i-1]){
                    candies[i]=candies[i-1] + 1;
                }
            }
            for (int i=A.length-2;i>=0;i--){
                if (A[i]>A[i+1]){
                    if (candies[i] <= candies[i+1] ){
                        candies[i] = candies[i+1] + 1;
                    }
                }
            }
            int total = 0;
            for (int candy : candies){
                total += candy;
            }
            return total;
        }
    }

}
