package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/longest-palindromic-subsequence/
 */

public class LongestPalindromicSubsequence {


    public int solve(String input){
        return new Solution().solve(input);
    }

    public static class Solution {
        public int solve(String A) {

            if (A.length() == 1){
                return 1;
            }
            if (A.length() == 2){
                return A.charAt(0) == A.charAt(1) ? 2 : 1;
            }
            int[][] memo = new int[A.length()][A.length()];

            for(int i=0;i<A.length();i++){
                for (int j=0;j<A.length();j++){
                    if (i == j){
                        memo[i][j] = 1;
                    }else{
                        memo[i][j] = -1;
                    }
                }
            }

            return solveRecursive(A.toCharArray(), 0, A.length()-1, memo);
        }

        private int solveRecursive(char[] input, int startIndex, int endIndex, int[][] memo){
            if (memo[startIndex][endIndex] != -1){
                return memo[startIndex][endIndex];
            }
            if (startIndex == endIndex){
                return 1;
            }
            if (startIndex == endIndex-1){
                if (input[startIndex] == input[endIndex]){
                    memo[startIndex][endIndex] = 2;
                    return 2;
                }else{
                    memo[startIndex][endIndex] = 0;
                    return 0;
                }
            }
            memo[startIndex][endIndex]
                    = Math.max(Math.max(((input[startIndex] == input[endIndex] ? 2 : 0 )+ solveRecursive(input, startIndex+1, endIndex-1, memo)),
                    solveRecursive(input, startIndex+1, endIndex, memo)), solveRecursive(input, startIndex, endIndex-1, memo));
            return memo[startIndex][endIndex];

        }

    }

}
