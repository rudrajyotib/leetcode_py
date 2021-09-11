package leet.solutions;

/*
https://leetcode.com/problems/set-matrix-zeroes/
Leetcode#73
 */

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void solve(int[][] matrix) {
        Solution solution = new Solution();
        solution.setZeroes(matrix);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rowsToReset = new HashSet<>();
            Set<Integer> colsToReset = new HashSet<>();
            int rowLength = matrix.length;
            int colLength = matrix[0].length;
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (matrix[i][j] == 0) {
                        rowsToReset.add(i);
                        colsToReset.add(j);
                    }
                }
            }
            for (Integer colIndex : colsToReset) {
                resetCol(colIndex, rowLength, matrix);
            }
            for (Integer rowIndex : rowsToReset) {
                resetRow(rowIndex, colLength, matrix);
            }
        }

        private void resetRow(int rowIndex, int colLength, int[][] matrix) {
            for (int i = 0; i < colLength; i++) {
                matrix[rowIndex][i] = 0;
            }
        }

        private void resetCol(int colIndex, int rowLength, int[][] matrix) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][colIndex] = 0;
            }
        }

    }

}
