/*
https://www.geeksforgeeks.org/problems/form-a-palindrome1455/1
 */

package gfg;

public class FormPalindrome {

    static int countMin(String str)
    {
        // code here
        char[] s = str.toCharArray();
        if (s.length == 1){
            return 0;
        }
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i=n-1;i>=0;i--){
            dp[i][i] = 1;
            for (int j=i+1; j<n; j++){
                if (s[i] == s[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[0][n-1];
    }



}
