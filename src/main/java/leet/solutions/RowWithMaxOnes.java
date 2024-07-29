/*
https://leetcode.com/problems/row-with-maximum-ones/
 */

package leet.solutions;

import java.util.Arrays;

public class RowWithMaxOnes {

    public int[] solve(int[][] arr) {
        return new Solution().rowAndMaximumOnes(arr);
    }

    static class Solution {
        public int[] rowAndMaximumOnes(int[][] arr) {
            int resultCol = -1;
            int resultRow = -1;
            int colLen = arr[0].length;
            for (int i = 0; i < arr.length; i++) {
                int firstOne = findFirstOne(arr[i]);
                if (firstOne != -1) {
                    if (resultRow == -1) {
                        resultCol = firstOne;
                        resultRow = i;
                    } else {
                        if (resultCol > firstOne) {
                            resultCol = firstOne;
                            resultRow = i;
                        }
                    }
                }
            }
            if (resultRow != -1) {
                resultCol = (colLen - resultCol);
            }
            return new int[]{resultRow, resultCol};
        }

        private int findFirstOne(int[] row) {
            Arrays.sort(row);
            if (row[0] == 1) {
                return 0;
            }
            if (row[row.length - 1] == 0) {
                return -1;
            }
            return binarySearchFirstOne(row, 0, row.length - 1);
        }

        private int binarySearchFirstOne(int[] row, int start, int end) {
            int mid = (start + end) / 2;
            if (row[mid] == 0 && row[mid + 1] == 1) {
                return mid + 1;
            }
            if (row[mid] == 0) {
                return binarySearchFirstOne(row, mid + 1, end);
            } else {
                return binarySearchFirstOne(row, start, mid - 1);
            }
        }
    }
}
