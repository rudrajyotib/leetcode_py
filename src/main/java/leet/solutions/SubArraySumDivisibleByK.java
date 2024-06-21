/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/description
 */


package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {

    public int solve(int[] nums, int k){
        return new Solution().subarraysDivByK(nums, k);
    }

    static class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> moduloCountMap = new HashMap<>();
            int moduloSum = 0;
            int count = 0;
            if (nums.length == 1){
                return nums[0] %k == 0 ? 1 : 0;
            }
            moduloCountMap.put(0, 1);
            for (int num : nums) {
                moduloSum = (moduloSum + num) % k;
                if (moduloSum < 0) {
                    moduloSum = moduloSum + k;
                }
                if (moduloCountMap.containsKey(moduloSum)) {
                    count += moduloCountMap.get(moduloSum);
                    moduloCountMap.put(moduloSum, moduloCountMap.get(moduloSum) + 1);
                } else {
                    moduloCountMap.put(moduloSum, 1);
                }

            }

            return count;
        }
    }
}
