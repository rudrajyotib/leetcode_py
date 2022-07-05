package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/longest-consecutive-sequence/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {


    public int solve(ArrayList<Integer> numbers) {
        return new Solution().longestConsecutive(numbers);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        public int longestConsecutive(List<Integer> numbers) {

            int maxRange = -1;
            Set<Integer> set = new HashSet<>(numbers.size());
            set.addAll(numbers);
            for (Integer number : numbers) {
                if (!set.contains(number - 1)) {
                    int sequenceStart = number;
                    while (set.contains(sequenceStart + 1)) {
                        ++sequenceStart;
                    }
                    int range = Math.abs(sequenceStart - number) + 1;
                    maxRange = Math.max(range, maxRange);
                }
            }


            return maxRange;
        }


    }

}
