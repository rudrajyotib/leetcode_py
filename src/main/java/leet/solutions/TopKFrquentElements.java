package leet.solutions;

/*
https://leetcode.com/problems/top-k-frequent-elements/
Leetcode#347
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrquentElements {

    public int[] solve(int[] nums, int k) {
        Solution solution = new Solution();
        return solution.topKFrequent(nums, k);
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                if (map.containsKey(num)) {
                    int x = map.get(num);
                    map.put(num, ++x);
                } else {
                    map.put(num, 1);
                }
            }

            return map.entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .collect(Collectors.toList())
                    .stream().skip(map.size() - k)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
                    .stream().mapToInt(integer -> integer)
                    .toArray();

        }
    }
}
