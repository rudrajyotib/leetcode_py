/*
https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 */

package hackerrank;

import java.util.List;

public class ConnectedCellInGrid {

    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        int rowLength = grid.size();
        int colLength = grid.get(0).size();
        boolean[][] visited = new boolean[rowLength][colLength];
        int[][] markedRegion = new int[rowLength][colLength];
        int region = 0;
        int maxRegion = Integer.MIN_VALUE;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid.get(i).get(j) == 1 && !visited[i][j]) {
                    ++region;
                    dfsRecursive(i, j, rowLength, colLength, visited, grid, markedRegion, region);
                }
            }
        }
        if (region == 0){
            return 0;
        }

        int[] regionArea = new int[region + 1];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                ++regionArea[markedRegion[i][j]];
            }
        }
        for (int i=1;i<regionArea.length;i++){
            maxRegion = Math.max(maxRegion, regionArea[i]);
        }

        return maxRegion;
    }

    static private void dfsRecursive(int row, int col, int rowLen, int colLen, boolean[][] visited, List<List<Integer>> grid, int[][] markedRegion, int regionIndex) {
        if (!isInRange(row, col, rowLen, colLen)) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (grid.get(row).get(col) == 1) {
            markedRegion[row][col] = regionIndex;
            dfsRecursive(row - 1, col - 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row - 1, col, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row - 1, col + 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row, col - 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row, col + 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row + 1, col - 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row + 1, col, rowLen, colLen, visited, grid, markedRegion, regionIndex);
            dfsRecursive(row + 1, col + 1, rowLen, colLen, visited, grid, markedRegion, regionIndex);
        }
    }


    private static boolean isInRange(int row, int col, int rowLen, int colLen) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }


}
