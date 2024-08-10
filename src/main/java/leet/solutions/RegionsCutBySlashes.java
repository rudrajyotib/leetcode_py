/*
https://leetcode.com/problems/regions-cut-by-slashes/
 */

package leet.solutions;

public class RegionsCutBySlashes {

    public int solve(String[] grid){
        return new Solution().regionsBySlashes(grid);
    }

    static class Solution {
        public int regionsBySlashes(String[] grid) {
            int rowLen = grid.length;
            int[][] upScaledGrid = new int[rowLen*3][rowLen*3];
            for (int i=0;i<rowLen;i++){
                for (int j = 0;j<rowLen;j++){
                    if (grid[i].charAt(j) == '/')
                        upScaledGrid[i * 3][j * 3 + 2] = upScaledGrid[i * 3 + 1][j * 3 + 1] = upScaledGrid[i * 3 + 2][j * 3] = 1;
                    else if (grid[i].charAt(j) == '\\')
                        upScaledGrid[i * 3][j * 3] = upScaledGrid[i * 3 + 1][j * 3 + 1] = upScaledGrid[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
            boolean[][] visited = new boolean[rowLen*3][rowLen*3];
            int regions = 0;
            int upScaledRowLen = rowLen * 3;
            for (int i =0;i<upScaledRowLen;i++){
                for(int j = 0; j<upScaledRowLen; j++){
                    if (!visited[i][j] && upScaledGrid[i][j] == 0 ){
                        ++regions;
                        dfsRecursive(i, j, upScaledGrid, upScaledRowLen, visited);
                    }
                }
            }
            return regions;
        }

        public void dfsRecursive(int row, int col, int[][] grid, int rowLen, boolean[][] visited){
            if (!isInRange(row, col, rowLen)){
                return;
            }
            if (visited[row][col]){
                return;
            }
            if (grid[row][col] == 1){
                return;
            }
            visited[row][col] = true;
            dfsRecursive(row+1, col, grid, rowLen, visited);
            dfsRecursive(row-1, col, grid, rowLen, visited);
            dfsRecursive(row, col+1, grid, rowLen, visited);
            dfsRecursive(row, col-1, grid, rowLen, visited);
        }




        private boolean isInRange(int row, int col, int rowLen){
            if (row <0 || row >=rowLen){
                return false;
            }
            return col >= 0 && col < rowLen;
        }
    }
}
