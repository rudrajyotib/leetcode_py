/*
https://www.geeksforgeeks.org/problems/minimum-cost-path3833/1
 */

package gfg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostPath {

    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int len = grid.length;
        int[][] costPath = new int[len][len];
        for (int i=0;i<len;i++){
            Arrays.fill(costPath[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[][] diffs = new int[][]{
                new int[]{0,1},
                new int[]{0,-1},
                new int[]{-1,0},
                new int[]{1,0},
        };
        queue.offer(new Integer[]{grid[0][0], 0, 0});
        while (!queue.isEmpty()){
            Integer[] cell = queue.remove();
            for (int[] diff: diffs){
                int x = cell[1] + diff[0];
                int y = cell[2] + diff[1];
                if (isInRange(x, y, len)){
                    int cost = grid[x][y] + cell[0];
                    if (costPath[x][y] > cost){
                        queue.offer(new Integer[]{cost, x, y});
                        costPath[x][y] = cost;
                    }
                }
            }
        }
        return costPath[len-1][len-1];
    }

    private boolean isInRange(int x, int y, int len){
        if (x < 0 || x >= len){
            return false;
        }
        return y >= 0 && y < len;
    }



}
