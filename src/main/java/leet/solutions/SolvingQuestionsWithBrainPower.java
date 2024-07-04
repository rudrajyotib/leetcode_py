/*
https://leetcode.com/problems/solving-questions-with-brainpower/
Copied from solution.
 */

package leet.solutions;

import java.util.Arrays;

public class SolvingQuestionsWithBrainPower {

    public long solve(int[][] questions){
        return new Solution().mostPoints(questions);
    }

    static class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];
            Arrays.fill(dp, 0);
            dp[n - 1] = questions[n - 1][0];

            for (int i = n - 2; i >= 0; --i) {
                dp[i] = questions[i][0];
                int skip = questions[i][1];
                if (i + skip + 1 < n) {
                    dp[i] += dp[i + skip + 1];
                }

                // dp[i] = max(solve it, skip it)
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }

            return dp[0];
        }
    }

}
