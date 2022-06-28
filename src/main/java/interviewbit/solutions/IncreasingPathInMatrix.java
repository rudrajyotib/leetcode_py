package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/increasing-path-in-matrix/
 */

import java.util.ArrayList;

public class IncreasingPathInMatrix {

    public int solve(ArrayList<ArrayList<Integer>> input) {
        return new Solution().solve(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int solve(ArrayList<ArrayList<Integer>> input) {

            int rows = input.size();
            int columns = input.get(0).size();
            if (rows==1 && columns==1){
                return 1;
            }
            int[][] dp = new int[rows][columns];
            dp[0][0] = 1;
            for (int i = 1; i < rows; i++) {
                if (input.get(i).get(0) > input.get(i - 1).get(0) && dp[i-1][0] != -1) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = -1;
                }
            }
            for (int i = 1; i < columns; i++) {
                if (input.get(0).get(i) > input.get(0).get(i - 1)  && dp[0][i-1] != -1 ) {
                    dp[0][i] = dp[0][i - 1] + 1;
                } else {
                    dp[0][i] = -1;
                }
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    int downMovement = (input.get(i - 1).get(j) < input.get(i).get(j) && dp[i - 1][j] != -1) ? dp[i - 1][j] : -1;
                    int rightMovement = (input.get(i).get(j - 1) < input.get(i).get(j) && dp[i][j - 1] != -1) ? dp[i][j - 1] : -1;
                    if (downMovement == -1 && rightMovement==-1){
                        dp[i][j] = -1;
                    }else {

                        dp[i][j] = Math.max(downMovement, rightMovement) + 1;
                    }
                }
            }


            return dp[rows - 1][columns - 1] == 1 ? -1 : dp[rows - 1][columns - 1];
        }
    }

}
