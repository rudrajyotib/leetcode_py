package leet.solutions;

/*
https://leetcode.com/problems/insert-interval/
Leetcode#57
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

    public int[][] solve(int[][] intervals, int[] newInterval) {
        Solution solution = new Solution();
        return solution.insert(intervals, newInterval);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (intervals.length == 0) {
                return new int[][]{{newInterval[0], newInterval[1]}};
            }
            int intervalsLength = intervals.length;

            List<int[]> intervalList = Arrays.asList(intervals);
            List<int[]> result = new ArrayList<>();
            if (newInterval[1] < intervals[0][0]) {
                result.add(0, newInterval);
                result.addAll(intervalList);
                return result.toArray(new int[1][1]);
            }
            if (newInterval[0] > intervals[intervalsLength - 1][1]) {
                result.addAll(intervalList);
                result.add(newInterval);
                return result.toArray(new int[1][1]);
            }
            if ((newInterval[0] <= intervals[0][0]) && (newInterval[1] >= intervals[intervalsLength - 1][1])) {
                return new int[][]{newInterval};
            }
            int startLocationIndex = 0;
            int endLocationIndex = 0;
            boolean startLocationInOverlap = false;
            boolean endLocationInOverlap = false;
            boolean startLocationFound = false;
            boolean endLocationFound = false;
            for (int i = 0; i < intervalsLength; i++) {
                if (startLocationFound && endLocationFound) {
                    break;
                }
                if (!startLocationFound) {
                    if (newInterval[0] < intervals[i][0]) {
                        startLocationFound = true;
                        startLocationIndex = i;
                    } else if ((newInterval[0] >= intervals[i][0]) && (newInterval[0] <= intervals[i][1])) {
                        startLocationFound = true;
                        startLocationIndex = i;
                        startLocationInOverlap = true;
                    }
                }
                if (startLocationFound && !endLocationFound) {
                    if (newInterval[1] < intervals[i][0]) {
                        endLocationFound = true;
                        endLocationIndex = i;
                    } else if ((newInterval[1] >= intervals[i][0]) && (newInterval[1] <= intervals[i][1])) {
                        endLocationFound = true;
                        endLocationIndex = i;
                        endLocationInOverlap = true;
                    }
                }
            }
            if (startLocationInOverlap) {
                if (!endLocationFound) {
                    intervalList.get(startLocationIndex)[1] = newInterval[1];
                    result.addAll(intervalList.subList(0, startLocationIndex + 1));
                } else {
                    if (!endLocationInOverlap) {
                        intervalList.get(startLocationIndex)[1] = newInterval[1];
                        result.addAll(intervalList.subList(0, startLocationIndex + 1));
                        result.addAll(intervalList.subList(endLocationIndex, intervalsLength));
                    } else {
                        intervalList.get(startLocationIndex)[1] = intervals[endLocationIndex][1];
                        result.addAll(intervalList.subList(0, startLocationIndex + 1));
                        result.addAll(intervalList.subList(endLocationIndex + 1, intervalsLength));
                    }
                }
            } else {
                result.addAll(intervalList.subList(0, startLocationIndex));
                result.add(new int[]{newInterval[0], 0});
                if (!endLocationFound) {
                    result.get(startLocationIndex)[1] = newInterval[1];
                } else {
                    if (!endLocationInOverlap) {
                        result.get(startLocationIndex)[1] = newInterval[1];
                        result.addAll(intervalList.subList(endLocationIndex, intervalsLength));
                    } else {
                        result.get(startLocationIndex)[1] = intervals[endLocationIndex][1];
                        result.addAll(intervalList.subList(endLocationIndex + 1, intervalsLength));
                    }
                }
            }

            return result.toArray(new int[1][1]);
        }
    }
}
