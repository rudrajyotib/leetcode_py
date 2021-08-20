package leet.solutions;

/*
https://leetcode.com/problems/spiral-matrix/
Leetcode#54
 */

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public Integer[] solve(int[][] matrix)
    {
        Solution solution = new Solution();
        return solution.spiralOrder(matrix).toArray(new Integer[1]);
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            int startRow = 0;
            int endRow = matrix.length-1;
            int startColumn = 0;
            int endColumn = matrix[0].length-1;
            List<Integer> result = new LinkedList<>();
            while (  (startRow<=endRow) && (startColumn <= endColumn)  )
            {
                result.addAll(printOneCircle(startRow, endRow, startColumn, endColumn, matrix));
                ++startRow;
                --endRow;
                ++startColumn;
                --endColumn;
            }
            return result;
        }

        private List<Integer> printOneCircle(int startRow,
                                             int endRow,
                                             int startColumn,
                                             int endColumn,
                                             int[][] matrix) {

            List<Integer> result = new LinkedList<>();
            if ((startRow==endRow) && (startColumn==endColumn))
            {
                result.add(matrix[startRow][startColumn]);
                return result;
            }
            if (startColumn == endColumn)
            {
                for (int i = startRow ; i <= endRow; i++) {
                    result.add(matrix[i][endColumn]);
                }
                return result;
            }
            if (startRow == endRow)
            {
                for (int i = startColumn; i <= endColumn; i++) {
                    result.add(matrix[startRow][i]);
                }
                return result;
            }
            for (int i = startColumn; i <= endColumn; i++) {
                result.add(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            for (int i = endColumn - 1; i >= startColumn; i--) {
                result.add(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                result.add(matrix[i][startColumn]);
            }
            return result;
        }

    }

}
