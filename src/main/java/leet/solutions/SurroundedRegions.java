package leet.solutions;

/*
https://leetcode.com/problems/surrounded-regions/
Leetcode#130
 */

public class SurroundedRegions {

    public void solve(char[][] board)
    {
        Solution solution = new Solution();
        solution.solve(board);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private boolean[][] visitedBoard;
        private int rowCount;
        private int colCount;

        public void solve(char[][] board) {
            if (board.length == 1)
            {
                return;
            }
            if (board[0].length == 1)
            {
                return;
            }
            visitedBoard = new boolean[board.length][board[0].length];
            this.rowCount = visitedBoard.length - 1;
            this.colCount = visitedBoard[0].length - 1;
            moveAroundPerimeter(board);
            for (int i=1;i<=rowCount-1;i++)
            {
                for (int j=1;j<=colCount-1;j++)
                {
                    if (('O' == board[i][j]) && (!visitedBoard[i][j]))
                    {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void moveAroundPerimeter(char[][] board)
        {
            for (int i=0;i<=colCount;i++)
            {
                dfs(board, 0, i);
            }
            for (int i=1;i<=rowCount;i++)
            {
                dfs(board, i, colCount);
            }
            for (int i=colCount-1;i>=0;i--)
            {
                dfs(board, rowCount, i);
            }
            for (int i=rowCount-1;i>=1;i--)
            {
                dfs(board, i, 0);
            }
        }

        private void dfs(char[][] board, int rowIndex, int colIndex)
        {
            if (!isInRange(rowIndex, colIndex))
            {
                return;
            }
            if (visitedBoard[rowIndex][colIndex])
            {
                return;
            }
            if ('X' == board[rowIndex][colIndex])
            {
                return;
            }
            visitedBoard[rowIndex][colIndex] = true;
            dfs(board, rowIndex-1, colIndex);
            dfs(board, rowIndex+1, colIndex);
            dfs(board, rowIndex, colIndex-1);
            dfs(board, rowIndex, colIndex+1);
        }




        private boolean isInRange(int rowIndex, int colIndex)
        {
            return ( (rowIndex>=0) && (rowIndex <= rowCount) && (colIndex >=0) && (colIndex <= colCount));
        }
    }

}
