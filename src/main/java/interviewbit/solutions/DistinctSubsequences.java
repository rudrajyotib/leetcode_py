package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/distinct-subsequences/
 */

public class DistinctSubsequences {


    public int solve(String fromString, String toString) {
        return new Solution().numDistinct(fromString, toString);
    }

    public static class Solution {
        public int numDistinct(String fromString, String toString) {

            int fromStringLength = fromString.length();
            int toStringLength = toString.length();

            int[][] dp = new int[fromStringLength + 1][toStringLength + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= fromStringLength; i++) {
                for (int j = 1; j <= toStringLength; j++) {
                    if (fromString.charAt(i-1) == toString.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[fromStringLength][toStringLength];
        }
    }


}
