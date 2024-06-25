/*
https://leetcode.com/problems/max-consecutive-ones-iii/
 */


package leet.solutions;

public class MaxConsecutive1s3 {


    public int solve(int[] nums, int k){
        return new Solution().longestOnes(nums, k);
    }

    static class Solution {
        public int longestOnes(int[] nums, int k) {
            int maxLength = 0;
            int zeroCount = 0;
            int leftPointer = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i] != 1) {
                    ++zeroCount;
                    if (zeroCount > k) {
                        while (zeroCount != k) {
                            if (nums[leftPointer] == 0) {
                                --zeroCount;
                            }
                            ++leftPointer;
                        }
                    }

                }
                maxLength = Math.max(maxLength, i-leftPointer+1);
            }
            return maxLength;
        }
    }

}
