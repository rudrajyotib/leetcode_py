package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/knight-on-chess-board/
 */

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {


    public int solve(int boardRows, int boardColumns, int startRowPosition, int startColumnPosition, int endRowPosition, int endColumnPosition){
        return new Solution().knight(boardRows, boardColumns, startRowPosition, startColumnPosition, endRowPosition, endColumnPosition);
    }


    public static class Solution {
        public int knight(int A, int B, int C, int D, int E, int F) {
            int[][] stepCount = new int[A+1][B+1];
            boolean[][] visitTracker = new boolean[A+1][B+1];
            stepCount[C][D] = 0;

            int[][] deltas = new int[][]{
                    new int[]{2,1},
                    new int[]{2,-1},
                    new int[]{-2,-1},
                    new int[]{-2,1},
                    new int[]{1,2},
                    new int[]{-1,2},
                    new int[]{1,-2},
                    new int[]{-1,-2},
            };

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{C, D});
            visitTracker[C][D] = true;
            while (!queue.isEmpty()){
                int[] cellPosition = queue.poll();
                if (cellPosition[0] == E && cellPosition[1] == F){
                    return stepCount[cellPosition[0]][cellPosition[1]];
                }
                for (int i=0;i<8;i++){
                    int rowPosition = cellPosition[0] + deltas[i][0];
                    int columnPosition = cellPosition[1] + deltas[i][1];
                    if ((inRange(A, B, rowPosition, columnPosition)) && !visitTracker[rowPosition][columnPosition]){
                        visitTracker[rowPosition][columnPosition] = true;
                        queue.add(new int[]{rowPosition, columnPosition});
                        stepCount[rowPosition][columnPosition] = stepCount[cellPosition[0]][cellPosition[1]] + 1;
                    }
                }

            }
            return -1;
        }


        private boolean inRange(int boardRows, int boardColumns, int rowPosition, int columnPosition){
            return ((rowPosition>=1) && (columnPosition>=1) && (rowPosition<=boardRows) && (columnPosition<=boardColumns));
        }
    }

}
