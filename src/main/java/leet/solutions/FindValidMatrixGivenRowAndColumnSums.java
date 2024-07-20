/*
https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums
 */

package leet.solutions;

public class FindValidMatrixGivenRowAndColumnSums {

    public int[][] solve(int[] rows, int[] cols){
        return new Solution().restoreMatrix(rows, cols);
    }


    static class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int rowLen = rowSum.length;
            int colLen = colSum.length;
            int[][] result = new int[rowLen][colLen];
            for (int i=0;i<rowLen;i++){
                for (int j=0;j<colLen;j++){
                    int min = Math.min(rowSum[i], colSum[j]);
                    result[i][j] = min;
                    rowSum[i] -= min;
                    colSum[j] -= min;
                }
            }

            return result;
        }
    }

}
