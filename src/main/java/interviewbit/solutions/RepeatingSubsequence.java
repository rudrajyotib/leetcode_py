package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/repeating-subsequence/
 */


public class RepeatingSubsequence {

    public int solve(String input){
        return new Solution().anytwo(input);
    }

    public static class Solution {
        public int anytwo(String input) {

            if (input.length() == 1){
                return 0;
            }

            int[][] dp = new int[input.length() + 1][input.length() + 1];

            for (int i=1;i<dp.length;i++){
                for (int j=1;j<dp.length;j++){
                    if (input.charAt(i-1) == input.charAt(j-1) && i != j){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            return dp[dp.length-1][dp.length-1] >=2 ? 1 : 0;

        }
    }

}
