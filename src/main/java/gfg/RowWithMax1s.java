/*
https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
 */

package gfg;

public class RowWithMax1s {
    public int rowWithMax1s(int[][] arr) {
        // code here
        int resultCol = -1;
        int resultRow = -1;
        for (int i=0;i<arr.length;i++){
            int firstOne = findFirstOne(arr[i]);
            if (firstOne != -1){
                if (resultRow == -1){
                    resultCol = firstOne;
                    resultRow = i;
                }else {
                    if (resultCol > firstOne){
                        resultCol = firstOne;
                        resultRow = i;
                    }
                }
            }
        }
        return resultRow;
    }

    private int findFirstOne(int[] row){
        if (row[0] == 1){
            return 0;
        }
        if (row[row.length-1] == 0){
            return -1;
        }
        return binarySearchFirstOne(row, 0, row.length-1);
    }

    private int binarySearchFirstOne(int[] row, int start, int end){
        int mid = (start + end) / 2;
        if (row[mid] == 0 && row[mid+1] == 1){
            return mid+1;
        }
        if (row[mid] == 0){
            return binarySearchFirstOne(row, mid+1, end);
        }else{
            return binarySearchFirstOne(row, start, mid-1);
        }
    }
}
