package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/black-shapes/
 */

public class BlackShapes {

    public int solve(String[] shapes){
        return new Solution().black(shapes);
    }

    public static class Solution {
        public int black(String[] A) {
            int rowLength = A.length;
            int columnLength = A[0].length();
            boolean[][] visitTracker = new boolean[rowLength][columnLength];
            int connectedShapes = 0;
            for (int i=0;i<rowLength;i++){
                for (int j=0;j<columnLength;j++){
                    if (!visitTracker[i][j] && A[i].charAt(j) == 'X'){
                        ++connectedShapes;
                        dfs(i,j, A, visitTracker, rowLength, columnLength);
                    }
                }
            }

            return connectedShapes;
        }

        private void dfs(int rowPosition, int columnPosition, String[] shapes, boolean[][] visitTracker, int rowLength, int columnLength){
            if (!inRange(rowPosition, columnPosition, rowLength, columnLength)){
                return;
            }
            if (visitTracker[rowPosition][columnPosition]){
                return;
            }
            visitTracker[rowPosition][columnPosition] = true;
            if (shapes[rowPosition].charAt(columnPosition) == 'O'){
                return;
            }
            dfs(rowPosition+1, columnPosition, shapes, visitTracker, rowLength, columnLength );
            dfs(rowPosition-1, columnPosition, shapes, visitTracker , rowLength, columnLength);
            dfs(rowPosition, columnPosition+1, shapes, visitTracker , rowLength, columnLength);
            dfs(rowPosition, columnPosition-1, shapes, visitTracker , rowLength, columnLength);
        }

        private boolean inRange(int rowPosition, int columnPosition, int rowLength, int columnLength){
            return ((rowPosition>=0) && (columnPosition >= 0) && (rowPosition<rowLength) && (columnPosition<columnLength));
        }
    }

}
