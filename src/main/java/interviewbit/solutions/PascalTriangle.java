package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/pascal-triangle/
 */

import java.util.ArrayList;

public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> solve(int limit) {
        return new Solution().solve(limit);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<ArrayList<Integer>> solve(int limit) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>(limit);
            if (limit == 0) {
                return result;
            }
            ArrayList<Integer> firstRow = new ArrayList<>(1);
            firstRow.add(1);
            result.add(firstRow);
            if (limit == 1) {
                return result;
            }
            ArrayList<Integer> secondRow = new ArrayList<>(2);
            secondRow.add(1);
            secondRow.add(1);
            result.add(secondRow);
            if (limit == 2) {
                return result;
            }
            for (int i = 3; i <= limit; i++) {
                ArrayList<Integer> row = new ArrayList<>(i);
                row.add(1);
                for (int rowCounter = 1; rowCounter < i - 1; rowCounter++) {
                    row.add(result.get(i - 2).get(rowCounter) + result.get(i - 2).get(rowCounter - 1));
                }
                row.add(1);
                result.add(row);
            }

            return result;
        }
    }


}
