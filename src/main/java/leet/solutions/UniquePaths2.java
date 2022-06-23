package leet.solutions;

/*
https://leetcode.com/problems/unique-paths-ii/
 */


public class UniquePaths2 {


    public int solve(int[][] obstacleGrid){
        return new Solution().uniquePathsWithObstacles(obstacleGrid);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            if (obstacleGrid[0][0] == 1){return 0;}

            int rowsInObstacleGrid = obstacleGrid.length;
            int columnsInObstacleGrid = obstacleGrid[0].length;

            if (obstacleGrid[rowsInObstacleGrid-1][columnsInObstacleGrid-1]==1){return 0;}

            int[][] obstacleNavigationGrid = new int[rowsInObstacleGrid][columnsInObstacleGrid];

            boolean obstacleFound = false;

            for (int i=0;i<columnsInObstacleGrid;i++){
                if (obstacleGrid[0][i] == 0){
                    obstacleNavigationGrid[0][i] = 1;
                }else{
                    obstacleFound = true;
                    break;
                }
            }

            if (rowsInObstacleGrid == 1){
                return obstacleFound?0:1;
            }

            obstacleFound = false;

            for (int i=0;i<rowsInObstacleGrid;i++){
                if (obstacleGrid[i][0] == 0){
                    obstacleNavigationGrid[i][0] = 1;
                }else{
                   obstacleFound = true;
                    break;
                }
            }

            if (columnsInObstacleGrid == 1){
                return obstacleFound?0:1;
            }

            for (int i=1;i<rowsInObstacleGrid;i++){
                for (int j=1;j<columnsInObstacleGrid;j++){
                    if (obstacleGrid[i][j]==0){
                        obstacleNavigationGrid[i][j] = obstacleNavigationGrid[i-1][j]
                                +obstacleNavigationGrid[i][j-1];
                    }
                }
            }


            return obstacleNavigationGrid[rowsInObstacleGrid-1][columnsInObstacleGrid-1];
        }
    }


}
