package gfg;

/*
https://practice.geeksforgeeks.org/problems/2e068e2342b9c9f40cfda1ed8e8119542d748fd8/1
 */

public class MatrixLastCell {

    public int[] solve(int[][] matrix){
        return new Solution().endPoints(matrix,  matrix.length,matrix[0].length);
    }

    static class Solution{
        public int [] endPoints(int [][]arr, int m, int n){
            //code here
            int row=0;
            int col=0;
            int[][] directions= new int[][]{
                    new int[]{-1,0},
                    new int[]{0,1},
                    new int[]{1,0},
                    new int[]{0,-1}
            };
            int dir = 1;
            while (true){
                if (arr[row][col] == 1){
                    dir = (dir+1)%4;
                    arr[row][col] = 0;
                }
                int tempRow = row + directions[dir][0];
                int tempCol = col + directions[dir][1];
                if (((tempRow<0) || (tempRow>=m))||((tempCol<0||tempCol>=n))){
                    return new int[]{row, col};
                }
                row = tempRow;
                col = tempCol;
            }

        }
    }

}
