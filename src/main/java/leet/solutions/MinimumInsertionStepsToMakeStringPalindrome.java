/*
https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */

package leet.solutions;

public class MinimumInsertionStepsToMakeStringPalindrome {

    public int solve(String s) {
        return new Solution().minInsertions(s);
    }

    static class Solution {
        public int minInsertions(String string) {
            char[] s = string.toCharArray();
            if (s.length == 1) {
                return 0;
            }
            int n = s.length;
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s[i] == s[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return n - dp[0][n - 1];
        }
    }
}
