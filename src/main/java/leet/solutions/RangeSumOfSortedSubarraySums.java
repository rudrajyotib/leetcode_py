/*
https://leetcode.com/problems/range-sum-of-sorted-subarray-sums
 */

package leet.solutions;

import java.util.ArrayList;
import java.util.List;

public class RangeSumOfSortedSubarraySums {

    public int solve(int[] nums, int n, int left, int right) {
        return new Solution().rangeSum(nums, n, left, right);
    }

    static class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {

            List<Integer> subArraySums = new ArrayList<>((n * (n + 1)) / 2);
            subArraySumRecursive(0, nums, subArraySums);
            subArraySums.sort(Integer::compare);
            int mod = 1000000007;
            int sum = 0;
            for (int i = left - 1; i < right; i++) {
                if (i >= subArraySums.size()) {
                    break;
                }
                sum += subArraySums.get(i);
                sum = sum % mod;
            }

            return sum;
        }

        private void subArraySumRecursive(int index, int[] nums, List<Integer> sums) {
            if (index >= nums.length) {
                return;
            }
            if (index > 0) {
                int size = sums.size();
                for (int i = 1; i <= index; i++) {
                    sums.add(sums.get(size - i) + nums[index]);
                }
            }
            sums.add(nums[index]);
            subArraySumRecursive(index + 1, nums, sums);
        }
    }
}
