/*
https://www.geeksforgeeks.org/problems/making-a-large-island/
 */

package gfg;

import java.util.*;

public class MakeLargeIsland {

    public int largestIsland(int N,int[][] grid)
    {
        // code here

        boolean[][] visited = new boolean[N][N];

        int islandIndex = 2;
        int maxIsland = 0;
        Map<Integer, Integer> islandIndexToSize = new HashMap<>();
        for (int i = 0; i< N; i++){
            for (int j = 0; j< N; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    int size = sizeOfIsland(i, j, grid, N, N, visited, islandIndex);
                    islandIndexToSize.put(islandIndex, size);
                    ++islandIndex;
                    maxIsland = Math.max(size, maxIsland);
                }
            }
        }
        int[][] deltas = new int[][]{
                new int[]{-1,0},
                new int[]{1,0},
                new int[]{0,-1},
                new int[]{0,1}
        };
        Set<Integer> checkedSets = new HashSet<>();
        for (int i = 0; i< N; i++){
            for (int j = 0; j< N; j++){
                if (grid[i][j] == 0 ){
                    int connectedBlocks = 0;
                    checkedSets.clear();
                    for(int[] delta: deltas){
                        int nextRow = i+delta[0];
                        int nextCol = j + delta[1];

                        if (isInRange(nextRow, nextCol, N, N)){
                            if (grid[nextRow][nextCol] > 1 && !checkedSets.contains(grid[nextRow][nextCol])) {
                                connectedBlocks += islandIndexToSize.get(grid[nextRow][nextCol]);
                                checkedSets.add(grid[nextRow][nextCol]);
                            }
                        }
                    }
                    connectedBlocks += 1;
                    maxIsland = Math.max(maxIsland, connectedBlocks);
                }
            }
        }



        return maxIsland;
    }

    private int sizeOfIsland(int row, int col, int[][] grid, int rowLen,  int colLen, boolean[][] visited, int updatedValue){
        Queue<Integer[]> queue = new LinkedList<>();
        int size = 0;
        queue.add(new Integer[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()){
            Integer[] rowCol = queue.remove();
            ++size;

            int nextRow = rowCol[0]-1;
            int nextCol = rowCol[1];
            grid[rowCol[0]][rowCol[1]] = updatedValue;
            if (isInRange(nextRow, nextCol, rowLen, colLen)){
                if (grid[nextRow][nextCol] == 1){
                    if (!visited[nextRow][nextCol]){
                        queue.add(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            nextRow = rowCol[0]+1;
            if (isInRange(nextRow, nextCol, rowLen, colLen)){
                if (grid[nextRow][nextCol] == 1){
                    if (!visited[nextRow][nextCol]){
                        queue.add(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            nextRow = rowCol[0];
            nextCol = rowCol[1]-1;
            if (isInRange(nextRow, nextCol, rowLen, colLen)){
                if (grid[nextRow][nextCol] == 1){
                    if (!visited[nextRow][nextCol]){
                        queue.add(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            nextCol = rowCol[1] + 1;
            if (isInRange(nextRow, nextCol, rowLen, colLen)){
                if (grid[nextRow][nextCol] == 1){
                    if (!visited[nextRow][nextCol]){
                        queue.add(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }

        }
        return size;
    }

    private boolean isInRange(int row, int col, int rowLen, int colLen){
        if (row<0 || row >= rowLen){
            return false;
        }
        return col >= 0 && col < colLen;
    }

}
