package leet.solutions;

/*
https://leetcode.com/problems/spiral-matrix-ii/
Leetcode#59
 */

public class SpiralMatrix2 {


    public int[][] solve(int n)
    {
        Solution solution = new Solution();
        return solution.generateMatrix(n);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private int[][] result;

        public int[][] generateMatrix(int n) {
            result = new int[n][n];
            fillInMatrix(n);
            return result;
        }

        private void fillInMatrix(int n)
        {
            int limit = n %2 == 0 ? n / 2 : ((n/2)+ 1);
            int startRow = 0;
            int startColumn = 0;
            int endRow = n -1;
            int endColumn = n-1;
            int startNumber = 0;
            for (int i=0;i<limit;i++)
            {
                startNumber=move(startRow, startColumn, endRow, endColumn, startNumber);
                ++startRow;
                ++startColumn;
                --endRow;
                --endColumn;
            }
        }

        private int move(int startRow, int startColumn, int endRow,  int endColumn, int startNumber)
        {
            int afterRightMovement = moveRight(startRow, startColumn, endColumn, startNumber);
            int afterDownMovement = moveDown(endColumn, startRow, endRow, afterRightMovement);
            int afterLeftMovement = moveLeft(endRow, endColumn, startColumn, afterDownMovement);
            return moveUp(startColumn, endRow, startRow, afterLeftMovement);
        }

        private int moveRight(int row, int startColumn, int endColumn, int startNumber)
        {
            for (int i=startColumn; i<=endColumn;i++)
            {
                this.result[row][i] = ++startNumber;
            }
            return startNumber;
        }

        private int moveDown(int column, int startRow, int endRow, int startNumber)
        {
            for(int i=startRow+1; i<=endRow;i++)
            {
                this.result[i][column] = ++startNumber;
            }
            return startNumber;
        }

        private int moveLeft(int row, int startColumn, int endColumn, int startNumber)
        {
            for (int i=startColumn-1;i>=endColumn;i--)
            {
                this.result[row][i] = ++startNumber;
            }
            return startNumber;
        }

        private int moveUp(int column, int startRow, int endRow, int startNumber)
        {
            for(int i=startRow-1;i>endRow;i--)
            {
                this.result[i][column] = ++startNumber;
            }
            return startNumber;
        }
    }

}
