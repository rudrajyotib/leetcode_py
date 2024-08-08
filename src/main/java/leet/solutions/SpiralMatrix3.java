/*
https://leetcode.com/problems/spiral-matrix-iii/
 */

package leet.solutions;

public class SpiralMatrix3 {

    public int[][] solve(int rows, int cols, int rStart, int cStart ){
        return new Solution().spiralMatrixIII(rows, cols, rStart, cStart);
    }

    static class Solution {
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            int[][] result = new int[rows*cols][2];
            int cellsToTraverse = rows * cols;
            int movements = 1;
            int cellsTraversed = 0;
            int r = rStart;
            int c = cStart;
            while (cellsTraversed < cellsToTraverse){
                for (int i=0;i<movements;i++){
                    if (isInRange(r, c, rows, cols)){
                        result[cellsTraversed][0] = r;
                        result[cellsTraversed][1] = c;
                        ++cellsTraversed;
                    }
                    ++c;
                }
                for (int i=0;i<movements;i++){
                    if (isInRange(r, c, rows, cols)){
                        result[cellsTraversed][0] = r;
                        result[cellsTraversed][1] = c;
                        ++cellsTraversed;
                    }
                    ++r;
                }
                ++movements;
                for (int i=0;i<movements;i++){
                    if (isInRange(r, c, rows, cols)){
                        result[cellsTraversed][0] = r;
                        result[cellsTraversed][1] = c;
                        ++cellsTraversed;
                    }
                    --c;
                }
                for (int i=0;i<movements;i++){
                    if (isInRange(r, c, rows, cols)){
                        result[cellsTraversed][0] = r;
                        result[cellsTraversed][1] = c;
                        ++cellsTraversed;
                    }
                    --r;
                }
                ++movements;
            }
            return result;
        }

        private boolean isInRange(int r, int c, int rLen, int cLen){
            if (r < 0 || r >= rLen){
                return false;
            }
            return c >= 0 && c < cLen;
        }


    }

}
