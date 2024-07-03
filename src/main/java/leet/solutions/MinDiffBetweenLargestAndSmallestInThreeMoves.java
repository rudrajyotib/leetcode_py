/*
https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 */

package leet.solutions;

import java.util.Arrays;

public class MinDiffBetweenLargestAndSmallestInThreeMoves {

    public int solve(int[] nums){
        return new Solution().minDifference(nums);
    }

    static class Solution {
        public int minDifference(int[] nums) {
            if (nums.length <= 4){
                return 0;
            }
            Arrays.sort(nums);
            int leftPointer = 0;
            int rightPointer = nums.length-3-1;
            int minDiff = nums[rightPointer] - nums[leftPointer];
            ++rightPointer;
            ++leftPointer;
            while (rightPointer < nums.length){
                minDiff = Math.min((nums[rightPointer] - nums[leftPointer]), minDiff);
                ++leftPointer;
                ++rightPointer;
            }
            return minDiff;
        }
    }

}
