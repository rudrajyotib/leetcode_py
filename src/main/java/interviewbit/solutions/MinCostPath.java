package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/min-cost-path/
 */

import java.util.LinkedList;
import java.util.Queue;

public class MinCostPath {

    public int solve(int rowLength, int columnLength, String[] directions){
        return new Solution().solve(rowLength, columnLength, directions);
    }

    public static class Solution {
        public int solve(int A, int B, String[] C) {
            char[][] directionMatrix = new char[A][B];
            for (int i=0;i<A;i++){
                for (int j=0;j<B;j++){
                    directionMatrix[i][j] = C[i].charAt(j);
                }
            }
            boolean[][] visitTracker = new boolean[A][B];
            int[][] distanceTracker = new int[A][B];

            Queue<PositionWithCost> queue = new LinkedList<>();
            queue.add(new PositionWithCost(0, 0, 0));

            while (!queue.isEmpty()){
                PositionWithCost positionWithCost = queue.poll();
                if (positionWithCost.cost > distanceTracker[positionWithCost.rowPosition][positionWithCost.columnPosition]){
                    continue;
                }
                if ((positionWithCost.rowPosition == A-1 ) && (positionWithCost.columnPosition == B-1)){
                    continue;
                }
                int upRow = positionWithCost.rowPosition-1;
                int upColumn = positionWithCost.columnPosition;
                if (inRange(upRow, upColumn, A, B) ){
                    int costToUpRow = 'U' == directionMatrix[positionWithCost.rowPosition][positionWithCost.columnPosition] ?
                            positionWithCost.cost : positionWithCost.cost+1;
                    if (!visitTracker[upRow][upColumn]){
                        queue.add(new PositionWithCost(upRow, upColumn, costToUpRow));
                        visitTracker[upRow][upColumn] = true;
                        distanceTracker[upRow][upColumn] = costToUpRow;
                    }else{
                        if (costToUpRow < distanceTracker[upRow][upColumn]){
                            queue.add(new PositionWithCost(upRow, upColumn, costToUpRow));
                            distanceTracker[upRow][upColumn] = costToUpRow;
                        }
                    }
                }
                int leftRow = positionWithCost.rowPosition;
                int leftColumn = positionWithCost.columnPosition-1;
                if (inRange(leftRow, leftColumn, A, B) ){
                    int costToLeft = 'L' == directionMatrix[positionWithCost.rowPosition][positionWithCost.columnPosition] ?
                            positionWithCost.cost : positionWithCost.cost+1;
                    if (!visitTracker[leftRow][leftColumn]){
                        queue.add(new PositionWithCost(leftRow, leftColumn, costToLeft));
                        visitTracker[leftRow][leftColumn] = true;
                        distanceTracker[leftRow][leftColumn] = costToLeft;
                    }else{
                        if (costToLeft < distanceTracker[leftRow][leftColumn]){
                            queue.add(new PositionWithCost(leftRow, leftColumn, costToLeft));
                            distanceTracker[leftRow][leftColumn] = costToLeft;
                        }
                    }
                }
                int downRow = positionWithCost.rowPosition+1;
                int downColumn = positionWithCost.columnPosition;
                if (inRange(downRow, downColumn, A, B) ){
                    int costToDown = 'D' == directionMatrix[positionWithCost.rowPosition][positionWithCost.columnPosition] ?
                            positionWithCost.cost : positionWithCost.cost+1;
                    if (!visitTracker[downRow][downColumn]){
                        queue.add(new PositionWithCost(downRow, downColumn, costToDown));
                        visitTracker[downRow][downColumn] = true;
                        distanceTracker[downRow][downColumn] = costToDown;
                    }else{
                        if (costToDown < distanceTracker[downRow][downColumn]){
                            queue.add(new PositionWithCost(downRow, downColumn, costToDown));
                            distanceTracker[downRow][downColumn] = costToDown;
                        }
                    }
                }
                int rightRow = positionWithCost.rowPosition;
                int rightColumn = positionWithCost.columnPosition+1;
                if (inRange(rightRow, rightColumn, A, B) ){
                    int costToRight = 'R' == directionMatrix[positionWithCost.rowPosition][positionWithCost.columnPosition] ?
                            positionWithCost.cost : positionWithCost.cost+1;
                    if (!visitTracker[rightRow][rightColumn]){
                        queue.add(new PositionWithCost(rightRow, rightColumn, costToRight));
                        visitTracker[rightRow][rightColumn] = true;
                        distanceTracker[rightRow][rightColumn] = costToRight;
                    }else{
                        if (costToRight < distanceTracker[rightRow][rightColumn]){
                            queue.add(new PositionWithCost(rightRow, rightColumn, costToRight));
                            distanceTracker[rightRow][rightColumn] = costToRight;
                        }
                    }
                }
            }

            return distanceTracker[A-1][B-1];
        }

        private boolean inRange(int rowPosition, int columnPosition, int rowLength, int columnLength){
            return ((rowPosition >= 0) && (columnPosition>=0) && (rowPosition<rowLength) && (columnPosition<columnLength));
        }

        private static class PositionWithCost{
            private final int rowPosition;
            private final int columnPosition;
            private final int cost;

            private PositionWithCost(int rowPosition, int columnPosition, int cost) {
                this.rowPosition = rowPosition;
                this.columnPosition = columnPosition;
                this.cost = cost;
            }
        }
    }

}
