package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */


import java.util.ArrayList;

public class PascalTriangleKthRow {

    public ArrayList<Integer> solve(int limit) {
        return new Solution().getRow(limit);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> getRow(int limit) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            if (limit == 0) {
                return row;
            }
            row.add(1);
            if (limit == 1) {
                return row;
            }
            for (int i = 2; i <= limit; i++) {
                ArrayList<Integer> currentRow = new ArrayList<>(i);
                currentRow.add(1);
                for (int rowCounter = 1; rowCounter < i ; rowCounter++) {
                    currentRow.add(row.get(rowCounter) + row.get(rowCounter - 1));
                }
                currentRow.add(1);
                row = currentRow;
            }
            return row;
        }
    }


}
