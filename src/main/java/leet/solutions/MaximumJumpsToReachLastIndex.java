/*
https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
 */

package leet.solutions;

import java.util.Arrays;

public class MaximumJumpsToReachLastIndex {

    public int solve(int[] nums, int target){
        return new Solution().maximumJumps(nums, target);
    }

    static class Solution {
        public int maximumJumps(int[] nums, int target) {
            int[] maxJumps = new int[nums.length];
            Arrays.fill(maxJumps, -1);
            maxJumps[0] = 0;
            for(int i=0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    if (Math.abs(nums[i]-nums[j])<=target){
                        if (maxJumps[i]!=-1) {
                            maxJumps[j] = Math.max(maxJumps[j], maxJumps[i] + 1);
                        }
                    }
                }
            }
            return maxJumps[nums.length-1]>0? maxJumps[nums.length-1]:-1;
        }
    }
}
