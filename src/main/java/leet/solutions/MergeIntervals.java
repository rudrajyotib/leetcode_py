package leet.solutions;

/*
https://leetcode.com/problems/merge-intervals/
Leetcode#56
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] solve(int[][] intervals) {
        Solution solution = new Solution();
        return solution.merge(intervals);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[][] merge(int[][] intervals) {

            @SuppressWarnings("rawtypes") List result = new ArrayList();

            if (intervals.length == 1) {
                return intervals;
            }

            intervals = Arrays.stream(intervals).sorted((ints, t1) -> {
                if (ints[0] != t1[0]) {
                    return Integer.compare(ints[0], t1[0]);
                }
                return Integer.compare(ints[1], t1[1]);
            }).collect(Collectors.toList())
                    .toArray(new int[1][1]);

            int[] lastInterval = intervals[0];

            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] == lastInterval[1]) {
                    lastInterval[1] = interval[1];
                    continue;
                }
                if (interval[0] > lastInterval[1]) {
                    //noinspection unchecked
                    result.add(lastInterval);
                    lastInterval = interval;
                    continue;
                }
                if (interval[1] > lastInterval[1]) {
                    lastInterval[1] = interval[1];
                }
            }
            //noinspection unchecked
            result.add(lastInterval);
            int[][] resultArray = new int[result.size()][2];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = (int[]) result.get(i);
            }
            return resultArray;
        }
    }
}
