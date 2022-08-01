package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/snake-ladder-problem/
 */

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {


    public int solve(int[][] ladder, int[][] snake){
        return new Solution().snakeLadder(ladder, snake);
    }

    public static class Solution {
        public int snakeLadder(int[][] A, int[][] B) {
            boolean[] visitTracker = new boolean[101];
            int[] movements = new int[101];
            for (int i=1;i<101;i++){
                movements[i] = 0;
            }
            for (int[] ladder : A){
                movements[ladder[0]] = ladder[1];
            }
            for (int[] snake: B){
                movements[snake[0]] = snake[1];
            }
//            visitTracker[1] = true;
            Queue<CellAndStep> queue = new LinkedList<>();
            queue.add(new CellAndStep(1, 0));
            while (!queue.isEmpty()){
                CellAndStep cellAndStep = queue.poll();
                if (!visitTracker[cellAndStep.cell]){
                    if (cellAndStep.cell == 100){
                        return cellAndStep.step;
                    }
                    visitTracker[cellAndStep.cell] = true;
                    for (int i=1;i<=6;i++){
                        int nextCell = cellAndStep.cell + i;
                        if (nextCell>100){
                            break;
                        }
                        if (movements[nextCell]>0){
                            visitTracker[nextCell] = true;
                            nextCell = movements[nextCell];
                        }
                        queue.add(new CellAndStep(nextCell, cellAndStep.step + 1));
                    }
                }
            }

            return -1;
        }

        private static class CellAndStep{
            private final int cell;
            private final int step;

            CellAndStep(int cell, int step){
                this.cell = cell;
                this.step = step;
            }

        }
    }

}
