package leet.solutions;

/*
https://leetcode.com/problems/longest-consecutive-sequence/
Leetcode#128
 */

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {

    public int solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.longestConsecutive(nums);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int longestConsecutive(int[] nums) {

            if (nums.length == 0)
            {
                return 0;
            }
            int maxCount = 1;

            Map<Integer, Integer[]> map = new HashMap<>();

            for (int num : nums) {
                if (!map.containsKey(num)) {
                    Integer[] range = {num, num};
                    if (map.containsKey(num + 1)) {
                        range[1] = map.get(num + 1)[1];
                    }
                    if (map.containsKey(num - 1)) {
                        range[0] = map.get(num - 1)[0];
                    }

                    if (!range[1].equals(range[0])) {
                        int consCount = Math.abs(range[1] - range[0]) + 1;
                        if (consCount > maxCount) {
                            maxCount = consCount;
                        }
                        map.put(range[0], range);
                        map.put(range[1], range);
                        map.put(num, range);
                    } else {
                        map.put(range[0], range);
                    }

                }
            }


            return maxCount;
        }
    }


}
