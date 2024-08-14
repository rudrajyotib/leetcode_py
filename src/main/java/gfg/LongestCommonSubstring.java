/*
https://www.geeksforgeeks.org/problems/longest-common-substring1452/1#
 */

package gfg;

public class LongestCommonSubstring {

    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int maxLength = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

}
