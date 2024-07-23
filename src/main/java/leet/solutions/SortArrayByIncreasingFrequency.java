/*
https://leetcode.com/problems/sort-array-by-increasing-frequency
 */

package leet.solutions;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public int[] solve(int[] nums) {
        return new Solution().frequencySort(nums);
    }


    static class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int[] result = new int[nums.length];
            int counter = 0;
            final List<Integer> sortedList = new ArrayList<>(nums.length);
            map.entrySet().stream().sorted((o1, o2) -> {
                        if (!Objects.equals(o1.getValue(), o2.getValue())) {
                            return Integer.compare(o1.getValue(), o2.getValue());
                        }
                        return Integer.compare(o2.getKey(), o1.getKey());
                    })
                    .forEach(integerIntegerEntry -> {
                        for (int i = 1; i <= integerIntegerEntry.getValue(); i++) {
                            sortedList.add(integerIntegerEntry.getKey());
                        }
                    });
            for (Integer i : sortedList) {
                result[counter] = i;
                ++counter;
            }
            return result;
        }
    }

}
