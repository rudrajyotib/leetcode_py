/*
https://www.geeksforgeeks.org/problems/covid-spread--141631
 */

package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {


    public int helpaterp(int[][] hospital) {
        // code here
        int rowLen = hospital.length;
        int colLen = hospital[0].length;

        Queue<Integer[]> queue = new LinkedList<>();
        int uninfectedCount = 0;
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (hospital[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                }
                if (hospital[i][j] == 1) {
                    ++uninfectedCount;
                }
            }
        }
        int timePassed = 0;
        while (!queue.isEmpty() && uninfectedCount > 0) {
            ++timePassed;
            int queueDepth = queue.size();
            for (int i = 0; i < queueDepth; i++) {
                Integer[] loc = queue.poll();

                assert loc != null;
                if (isInRange(loc[0] - 1, loc[1], rowLen, colLen)) {
                    if (!visited[loc[0] - 1][loc[1]] && hospital[loc[0] - 1][loc[1]] == 1) {
                        --uninfectedCount;
                        visited[loc[0] - 1][loc[1]] = true;
                        queue.add(new Integer[]{loc[0] - 1, loc[1]});
                    }
                }
                if (isInRange(loc[0] + 1, loc[1], rowLen, colLen)) {
                    if (!visited[loc[0] + 1][loc[1]] && hospital[loc[0] + 1][loc[1]] == 1) {
                        --uninfectedCount;
                        visited[loc[0] + 1][loc[1]] = true;

                        queue.add(new Integer[]{loc[0] + 1, loc[1]});
                    }
                }
                if (isInRange(loc[0], loc[1] - 1, rowLen, colLen)) {
                    if (!visited[loc[0]][loc[1] - 1] && hospital[loc[0]][loc[1] - 1] == 1) {
                        --uninfectedCount;
                        visited[loc[0]][loc[1] - 1] = true;

                        queue.add(new Integer[]{loc[0], loc[1] - 1});
                    }
                }
                if (isInRange(loc[0], loc[1] + 1, rowLen, colLen)) {
                    if (!visited[loc[0]][loc[1] + 1] && hospital[loc[0]][loc[1] + 1] == 1) {
                        --uninfectedCount;
                        visited[loc[0]][loc[1] + 1] = true;
                        queue.add(new Integer[]{loc[0], loc[1] + 1});
                    }
                }

            }
        }
        if (uninfectedCount <= 0) {
            return timePassed;
        }
        return -1;
    }

    private boolean isInRange(int row, int col, int rowLen, int colLen) {
        if ((row < 0) || (row >= rowLen)) {
            return false;
        }
        return (col >= 0) && (col < colLen);
    }


}
