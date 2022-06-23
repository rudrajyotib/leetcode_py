package leet.solutions;

/*
https://leetcode.com/problems/unique-paths/
 */

public class UniquePaths {

    public int solve(int m,int n){
        return new Solution().uniquePaths(m, n);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m==1 || n==1){return 1;}
            int[][] solutionGrid = new int[m][n];
            for (int i=0;i<m;i++){
                solutionGrid[i][0] = 1;
            }
            for (int i=0;i<n;i++){
                solutionGrid[0][i] = 1;
            }

            for (int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    solutionGrid[i][j] =
                            solutionGrid[i-1][j] + solutionGrid[i][j-1];
                }
            }
            return solutionGrid[m-1][n-1];
        }
    }

}
