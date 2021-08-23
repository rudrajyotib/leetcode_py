package leet.solutions;

/*
https://leetcode.com/problems/word-search/
Leetcode#79
 */

public class WordSearch {

    public boolean solve(char[][] board, String word)
    {
        Solution solution = new Solution();
        return solution.exist(board, word);
    }

    class Solution {

        private boolean[][] visited;
        private int columnCount;
        private int rowCount;
        private char[][] dataGrid;
        private char[] target;


        public boolean exist(char[][] board, String word) {
            this.rowCount = board.length;
            this.columnCount = board[0].length;
            this.visited = new boolean[rowCount][columnCount];
            this.dataGrid = board;
            this.target = word.toCharArray();

            for (int i=0;i<rowCount;i++)
            {
                for (int j=0;j<columnCount;j++)
                {
                    if (searchRecursive(new int[]{i,j}, 0))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean searchRecursive(int[] boardPosition, int wordPosition)
        {
            if (!inRange(boardPosition))
            {
                return false;
            }
            if (visited[boardPosition[0]][boardPosition[1]])
            {
                return false;
            }
            if ( dataGrid[boardPosition[0]][boardPosition[1]] == target[wordPosition] )
            {
                if (wordPosition+1 == target.length)
                {
                    return true;
                }
                visited[boardPosition[0]][boardPosition[1]] = true;
                if (
                        searchRecursive(new int[]{boardPosition[0], boardPosition[1]+1}, wordPosition+1) ||
                        searchRecursive(new int[]{boardPosition[0], boardPosition[1]-1}, wordPosition+1) ||
                        searchRecursive(new int[]{boardPosition[0]+1, boardPosition[1]}, wordPosition+1) ||
                        searchRecursive(new int[]{boardPosition[0]-1, boardPosition[1]}, wordPosition+1)
                )
                {
                    return true;
                }else
                {
                    visited[boardPosition[0]][boardPosition[1]] = false;
                }
            }
            return false;
        }

        private boolean inRange(int[] position) {
            return ((position[0] >= 0) && (position[0] <= rowCount - 1) && (position[1] >= 0) && (position[1] <= columnCount - 1));
        }

    }

}
