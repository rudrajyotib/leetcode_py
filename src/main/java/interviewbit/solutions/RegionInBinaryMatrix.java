package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/region-in-binarymatrix/
 */

public class RegionInBinaryMatrix {

    public int solve(int[][] binaryMatrix){
        return new Solution().solve(binaryMatrix);
    }

    public static class Solution {
        public int solve(int[][] A) {
            int rowLength = A.length;
            int columnLength = A[0].length;

            int[][] markedRegion = new int[rowLength][columnLength];
            for (int i=0;i<rowLength;i++){
                for (int j = 0;j<columnLength;j++){
                    markedRegion[i][j] = -1;
                }
            }
            int regionIndex = -1;
            for (int i=0;i<rowLength;i++){
                for (int j =0 ; j<columnLength;j++){
                    if (A[i][j] == 1 ){
                        ++regionIndex;
                        dfs(A, i, j, rowLength, columnLength, regionIndex, markedRegion);
                    }
                }
            }
            if (regionIndex == -1){
                return 0;
            }
            int[] regionIndexCounter = new int[regionIndex+1];
            for (int i=0;i<rowLength;i++){
                for (int j=0;j<columnLength;j++){
                    if (A[i][j] == 1){
                        ++regionIndexCounter[markedRegion[i][j]];
                    }
                }
            }
            int maxLength = 0;
            for (int i=0;i<=regionIndex;i++){
                maxLength = Math.max(maxLength, regionIndexCounter[i]);
            }

            return maxLength;
        }

        private void dfs(int[][] matrix, int rowPosition, int columnPosition, int rowLength, int columnLength, int regionIndex, int[][] markedRegions){
            if (!inRange(rowPosition, columnPosition, rowLength, columnLength)){
                return;
            }
            if (matrix[rowPosition][columnPosition] == 0){
                return;
            }
            if (markedRegions[rowPosition][columnPosition]>-1){
                return;
            }
            markedRegions[rowPosition][columnPosition] = regionIndex;
            dfs(matrix, rowPosition+1, columnPosition, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition+1, columnPosition+1, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition+1, columnPosition-1, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition-1, columnPosition, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition-1, columnPosition+1, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition-1, columnPosition-1, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition, columnPosition+1, rowLength, columnLength, regionIndex, markedRegions);
            dfs(matrix, rowPosition, columnPosition-1, rowLength, columnLength, regionIndex, markedRegions);

        }

        private boolean inRange(int rowPosition, int columnPosition, int rowLength, int columnLength){
            return ((rowPosition>=0) && (columnPosition>=0) && (rowPosition<rowLength) && (columnPosition<columnLength));
        }
    }

}
