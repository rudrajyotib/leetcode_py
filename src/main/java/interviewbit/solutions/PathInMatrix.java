package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/path-in-matrix/
 */

public class PathInMatrix {


    public boolean solve(int[][] matrix){
        return new Solution().checkPath(matrix) == 1;
    }

    public static class Solution {
        public int checkPath(int[][] A) {

            int rowCount = A.length;
            int columnCount = A[0].length;

            boolean[][] adjacencyMatrix = new boolean[rowCount][columnCount];
            boolean[][] visitTracker = new boolean[rowCount][columnCount];
            int[] startCoordinate = new int[2];
            int[] endCoordinates = new int[2];

            for (int i=0;i<rowCount;i++){
                for (int j=0;j<columnCount;j++){
                    if (A[i][j] == 0){
                        adjacencyMatrix[i][j] = false;
                    }
                    else {
                        adjacencyMatrix[i][j] = true;
                        if (A[i][j] == 1){
                            startCoordinate[0] = i;
                            startCoordinate[1] = j;
                        }else if (A[i][j] == 2){
                            endCoordinates[0] = i;
                            endCoordinates[1] = j;
                        }
                    }
                }
            }

            dfs(adjacencyMatrix, visitTracker, startCoordinate[0], startCoordinate[1], rowCount, columnCount);


            return visitTracker[endCoordinates[0]][endCoordinates[1]] ? 1 : 0;
        }

        private void dfs(boolean[][] adjacencyMatrix, boolean[][] visitTracker, int rowPosition, int columnPosition, int rowLength, int columnLength){
            if (!inRange(rowPosition, columnPosition, rowLength, columnLength)){
                return;
            }
            if (visitTracker[rowPosition][columnPosition]){
                return;
            }
            if (!adjacencyMatrix[rowPosition][columnPosition]){
                return;
            }
            visitTracker[rowPosition][columnPosition] = true;
            dfs(adjacencyMatrix, visitTracker, rowPosition+1, columnPosition, rowLength, columnLength);
            dfs(adjacencyMatrix, visitTracker, rowPosition-1, columnPosition, rowLength, columnLength);
            dfs(adjacencyMatrix, visitTracker, rowPosition, columnPosition+1, rowLength, columnLength);
            dfs(adjacencyMatrix, visitTracker, rowPosition, columnPosition-1, rowLength, columnLength);
        }

        private boolean inRange(int rowPosition, int columnPosition, int rowLength, int columnLength){
            return ((rowPosition>=0) && (rowPosition<rowLength) && (columnPosition>=0) && (columnPosition<columnLength));
        }

    }


}
