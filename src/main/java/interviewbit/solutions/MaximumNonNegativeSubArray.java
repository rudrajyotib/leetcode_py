package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/max-non-negative-subarray/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaximumNonNegativeSubArray {

    public ArrayList<Integer> solve(ArrayList<Integer> input) {
        return new Solution().maxset(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> maxset(ArrayList<Integer> input) {
            boolean negativeStreak = true;
            int currentSumStreak = 0;
            List<ArrayList<Long>> segments = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                int currentNumber = input.get(i);
                if (currentNumber < 0) {
                    negativeStreak = true;
                } else {
                    if (negativeStreak) {
                        ArrayList<Long> positiveSubArray = new ArrayList<>();
                        positiveSubArray.add((long) currentNumber);
                        positiveSubArray.add((long) i);
                        positiveSubArray.add((long) currentNumber);
                        segments.add(positiveSubArray);
                        negativeStreak = false;
                    } else {
                        segments.get(segments.size() - 1).set(0, segments.get(segments.size() - 1).get(0) + currentNumber);
                        segments.get(segments.size() - 1).add((long) currentNumber);
                    }
                }
            }
            if (segments.isEmpty()) {
                return new ArrayList<>();
            }
            segments.sort((o1, o2) -> {
                if (!Objects.equals(o1.get(0), o2.get(0))) {
                    return Long.compare(o1.get(0), o2.get(0)) * -1;
                }
                if (o1.size() != o2.size()) {
                    return Integer.compare(o1.size(), o2.size()) * -1;
                }

                return Long.compare(o1.get(1), o2.get(1));
            });
            ArrayList<Long> topList = segments.get(0);
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 2; i < topList.size(); i++) {
                result.add(topList.get(i).intValue());
            }
            return result;

        }
    }

}
