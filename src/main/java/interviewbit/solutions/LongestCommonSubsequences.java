package interviewbit.solutions;


/*
https://www.interviewbit.com/problems/longest-common-subsequence/
 */

import java.util.Arrays;

public class LongestCommonSubsequences {

    public int solve(String first, String second){
        return new Solution().solve(first, second);
    }


    public static class Solution {
        public int solve(String first, String second) {

            int[][] dp = new int[first.length()+1][second.length()+1];

            for (int i=0;i<dp.length;i++){
                dp[i][0] = 0;
            }

            Arrays.fill(dp[0], 0);

            for (int i=1;i<dp.length;i++){
                for (int j = 1;j<dp[0].length; j++){
                    if (first.charAt(i-1) == second.charAt(j-1)){
                        dp[i][j] = Math.max(1+dp[i-1][j-1],
                                Math.max(dp[i-1][j], dp[i][j-1]));
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }


            return dp[first.length()][second.length()];
        }
    }

}
