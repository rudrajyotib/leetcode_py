package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * https://leetcode.com/problems/two-sum/
     * Leetcode#1
     */

    public static class Solution {


        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> number_index_map = new HashMap<>(nums.length);

            for (int i = 0; i < nums.length; i++) {
                int deficit = target - nums[i];
                if (number_index_map.containsKey(deficit)) {
                    return new int[]{i, number_index_map.get(deficit)};
                }
                number_index_map.put(nums[i], i);
            }

            return new int[]{1, 2};
        }
    }
}
