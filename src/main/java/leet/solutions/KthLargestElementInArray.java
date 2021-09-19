package leet.solutions;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
Leetcode#215
 */

import java.util.Arrays;

public class KthLargestElementInArray {

    public int solve(int[] nums, int k)
    {
        Solution solution = new Solution();
        return solution.findKthLargest(nums, k);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }
}
