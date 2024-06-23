/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description
 */

package leet.solutions;

import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsDiffLessThanEqualToLimit {

    public int solve(int[] nums, int limit) {
        return new Solution().longestSubarray(nums, limit);
    }

    static class Solution {
        public int longestSubarray(int[] nums, int limit) {

            LinkedList<Integer> incresingOrder = new LinkedList<>();
            LinkedList<Integer> decreasingOrder = new LinkedList<>();

            int leftIndex = 0;
            int maxLength = 1;
            incresingOrder.add(nums[0]);
            decreasingOrder.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];

                while (!incresingOrder.isEmpty()) {
                    if (incresingOrder.getLast() > num) {
                        incresingOrder.removeLast();
                    }else {
                        break;
                    }
                }
                incresingOrder.add(num);

                while (!decreasingOrder.isEmpty()) {
                    if (decreasingOrder.getLast() < num) {
                        decreasingOrder.removeLast();
                    } else {
                        break;
                    }
                }
                decreasingOrder.add(num);

                if ((decreasingOrder.getFirst() - incresingOrder.getFirst()) > limit) {
                    while ((decreasingOrder.getFirst() - incresingOrder.getFirst()) > limit) {
                        if (nums[leftIndex] == decreasingOrder.getFirst()) {
                            decreasingOrder.removeFirst();
                        }
                        if (nums[leftIndex] == incresingOrder.getFirst()) {
                            incresingOrder.removeFirst();
                        }
                        ++leftIndex;
                    }
                }
                maxLength = Math.max(maxLength, i - leftIndex + 1);

            }
            return maxLength;
        }
    }

}
