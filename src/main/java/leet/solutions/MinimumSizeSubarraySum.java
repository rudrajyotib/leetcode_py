package leet.solutions;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/
Leetcode#209
 */

public class MinimumSizeSubarraySum {

    public int solve(int target, int[] nums) {
        Solution solution = new Solution();
        return solution.minSubArrayLen(target, nums);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int tempSum = 0;
            int startIndex = 0;
            int minLength = Integer.MAX_VALUE;


            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return 1;
                }
                tempSum = tempSum + nums[i];

                if ((tempSum) < target) {
                    continue;
                }

                minLength = Math.min(minLength, (i - startIndex) + 1);


                for (int k = startIndex; k < i; k++) {

                    if (tempSum >= target) {
                        minLength = Math.min(minLength, i + 1 - k);
                    }
                    if (tempSum < target) {
                        startIndex = k;
                        break;
                    }
                    tempSum = tempSum - nums[k];
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }

}
