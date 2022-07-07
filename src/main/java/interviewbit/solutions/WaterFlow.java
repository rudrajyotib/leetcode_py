package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/water-flow/
 */


public class WaterFlow {

    public int solve(int[][] terrain){
        return new Solution().solve(terrain);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int solve(int[][] terrain) {
            int rowCount = terrain.length;
            int columnCount = terrain[0].length;

            boolean[][] visitTracker = new boolean[rowCount][columnCount];
            boolean[][] blueLake = new boolean[rowCount][columnCount];
            boolean[][] redLake = new boolean[rowCount][columnCount];

            for (int i=0;i<columnCount;i++){
                trackWaterFlow(terrain, 0, i,  rowCount, columnCount, visitTracker, blueLake);
            }
            for (int i=1;i<rowCount;i++){
                trackWaterFlow(terrain, i, 0, rowCount, columnCount, visitTracker, blueLake);
            }
            for (int i=0;i<rowCount;i++){
                for (int j=0;j<columnCount;j++){
                    visitTracker[i][j] = false;
                }
            }
            for (int i=rowCount-1;i>=0;i--){
                trackWaterFlow(terrain, i, columnCount-1, rowCount, columnCount, visitTracker, redLake);
            }
            for (int i=0;i<columnCount-1;i++){
                trackWaterFlow(terrain, rowCount-1, i, rowCount, columnCount, visitTracker, redLake);
            }

            int waterMixCellCount = 0;
            for (int i=0;i<rowCount;i++){
                for (int j=0;j<columnCount;j++){
                    if(blueLake[i][j] && redLake[i][j]){
                        ++waterMixCellCount;
                    }
                }
            }


            return waterMixCellCount;
        }

        private void trackWaterFlow(int[][] terrain, int row, int column, int rowCount, int columnCount, boolean[][] visitTracker, boolean[][] waterTracker){
            if (visitTracker[row][column]){
                return;
            }
            visitTracker[row][column] = true;
            waterTracker[row][column] = true;
            if (inRange(row+1, column, rowCount, columnCount) && terrain[row+1][column] >= terrain[row][column] ){
                trackWaterFlow(terrain, row+1, column, rowCount, columnCount, visitTracker, waterTracker);
            }
            if (inRange(row-1, column, rowCount, columnCount) && terrain[row-1][column] >= terrain[row][column] ){
                trackWaterFlow(terrain, row-1, column, rowCount, columnCount, visitTracker, waterTracker);
            }
            if (inRange(row, column+1, rowCount, columnCount) && terrain[row][column+1] >= terrain[row][column] ){
                trackWaterFlow(terrain, row, column+1, rowCount, columnCount, visitTracker, waterTracker);
            }
            if (inRange(row, column-1, rowCount, columnCount) && terrain[row][column-1] >= terrain[row][column] ){
                trackWaterFlow(terrain, row, column-1, rowCount, columnCount, visitTracker, waterTracker);
            }
        }

        private boolean inRange(int row, int column, int rowCount, int columnCount){
            return ((row>=0) && (row<rowCount) && (column>=0) && (column<columnCount));
        }

    }


}
