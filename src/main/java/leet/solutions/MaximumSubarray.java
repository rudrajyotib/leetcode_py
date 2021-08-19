package leet.solutions;

/*
https://leetcode.com/problems/maximum-subarray/
Leetcode#53
 */

public class MaximumSubarray {

    public int solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.maxSubArray(nums);
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxAtCurrent = nums[0];
            int max = maxAtCurrent;
            for (int i=1;i<nums.length;i++)
            {
                maxAtCurrent = Math.max(nums[i], maxAtCurrent+nums[i] );
                if (maxAtCurrent > max)
                {
                    max = maxAtCurrent;
                }
            }

            return max;
        }
    }

}
