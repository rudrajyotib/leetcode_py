package gfg;

/*
https://practice.geeksforgeeks.org/problems/90a81c305b1fe939b9230a67824749ceaa493eab/1
 */


public class CountFreeCells {

    public long[] solve(int[][] arr, int n){
        return new Solution().countZero(n, arr.length, arr);
    }


    static class Solution {
        long[] countZero(int n, int k, int[][] arr){
            // code here
            boolean[] rows = new boolean[n];
            boolean[] columns = new boolean[n];
            int setRows = 0;
            int setCols = 0;
            long unsetCells = (long) n * n;
            long[] result = new long[k];
            for (int i=0;i<k;i++){
                int row = arr[i][0]-1;
                int col = arr[i][1] -1;
                if (!rows[row]){
                    ++setRows;
                    rows[row] = true;
                    unsetCells -= (n-setCols);
                }
                if (!columns[col]){
                    ++setCols;
                    columns[col] = true;
                    unsetCells -= (n-setRows);
                }
                result[i] = unsetCells;
            }
            return result;

        }
    }


}
