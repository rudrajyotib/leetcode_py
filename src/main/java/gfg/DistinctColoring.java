package gfg;

/*
https://practice.geeksforgeeks.org/problems/844b4fdcd988ac5461324d62d43f7892749a113c/1
 */

public class DistinctColoring {

    public long solve(int houses, int[] redPrices, int[] greenPrices, int[] bluePrices){
        return new Solution().distinctColoring(houses, redPrices, greenPrices, bluePrices);
    }


    static class Solution{
        public  long distinctColoring(int n, int[] r, int[] g, int[] b){
            //code here
            long[][] dp = new long[n][3];
            dp[0] = new long[]{r[0], g[0], b[0]};
            for (int i=1;i<n;i++){
                dp[i][0] = r[i] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = g[i] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = b[i] + Math.min(dp[i-1][1], dp[i-1][0]);
            }
            return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        }
    }


}
