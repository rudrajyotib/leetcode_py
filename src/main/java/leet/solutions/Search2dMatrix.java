package leet.solutions;

/*
https://leetcode.com/problems/search-a-2d-matrix/
Leetcode#74
 */

public class Search2dMatrix {

    public boolean solve(int[][] matrix, int target)
    {
        Solution solution = new Solution();
        return solution.searchMatrix(matrix, target);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowLength = matrix.length-1;
            int columnLength = matrix[0].length - 1;
            if ((target < matrix[0][0]) || (target > matrix[rowLength][columnLength]))
            {
                return false;
            }
            int row = findRow(matrix, target, 0, rowLength, columnLength);
            if (row == -1)
            {
                return false;
            }
            return findElementInRow(matrix, target, row, 0, columnLength);
        }


        private boolean findElementInRow(int[][] matrix, int target, int rowIndex, int startColumnIndex, int endColumnIndex)
        {
            if (startColumnIndex>endColumnIndex)
            {
                return false;
            }
            int mid = (startColumnIndex + endColumnIndex) / 2;
            if (target == matrix[rowIndex][mid])
            {
                return true;
            }
            if (target > matrix[rowIndex][mid])
            {
                return findElementInRow(matrix, target, rowIndex, mid+1, endColumnIndex);
            }else
            {
                return findElementInRow(matrix, target, rowIndex, startColumnIndex, mid-1);
            }
        }

        private int findRow(int[][] matrix, int target, int startRowIndex, int endRowIndex, int columnLength)
        {
            int mid = (startRowIndex + endRowIndex) / 2;
            if ((target>=matrix[mid][0]) && (target<=matrix[mid][columnLength]))
            {
                return mid;
            }
            if (startRowIndex > endRowIndex)
            {
                return -1;
            }
            if ((target<matrix[mid][0]))
            {
                return findRow(matrix, target, startRowIndex, mid-1, columnLength);
            }else
            {
                return findRow(matrix, target, mid+1, endRowIndex, columnLength);
            }
        }


    }

}
