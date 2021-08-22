package leet.solutions;

/*
https://leetcode.com/problems/number-of-islands/
Leetcode#200
 */

public class NumberOfIslands {

    public int solve(char[][] grid) {
        Solution solution = new Solution();
        return solution.numIslands(grid);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private boolean[][] islands;
        private int columnCount;
        private int rowCount;
        private char[][] dataGrid;

        public int numIslands(char[][] grid) {

            rowCount = grid.length;
            columnCount = grid[0].length;
            islands = new boolean[rowCount][columnCount];
            int islandCount = 0;
            this.dataGrid = grid;

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    if ('1' == grid[i][j]) {
                        if (!(islands[i][j])) {
                            ++islandCount;
                        }
                        markIslandsRecursive(new int[]{i, j});
                    }
                }
            }

            return islandCount;
        }

        private void markIslandsRecursive(int[] position) {
            if (!inRange(position)) {
                return;
            }
            if (islands[position[0]][position[1]]) {
                return;
            }
            if ('0' == dataGrid[position[0]][position[1]]) {
                return;
            }
            islands[position[0]][position[1]] = true;
            markIslandsRecursive(new int[]{(position[0] - 1), (position[1])});
            markIslandsRecursive(new int[]{(position[0] + 1), (position[1])});
            markIslandsRecursive(new int[]{(position[0]), (position[1] - 1)});
            markIslandsRecursive(new int[]{position[0], (position[1] + 1)});
        }

        private boolean inRange(int[] position) {
            return ((position[0] >= 0) && (position[0] <= rowCount - 1) && (position[1] >= 0) && (position[1] <= columnCount - 1));
        }

    }

}
