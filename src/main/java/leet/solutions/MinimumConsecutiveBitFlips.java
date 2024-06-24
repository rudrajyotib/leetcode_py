/*
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/
 */

package leet.solutions;

public class MinimumConsecutiveBitFlips {

    public int solve(int[] nums, int k){
        return new Solution().minKBitFlips(nums, k);
    }

    static class Solution {
        public int minKBitFlips(int[] nums, int k) {
            int ans = 0, flips = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] + flips) % 2 == 0) {
                    if (i > nums.length - k) {
                        return -1;
                    } else {
                        ans++;
                        flips++;
                        nums[i] = -1;
                    }
                }
                if (i + 1 >= k) {
                    flips -= (nums[i - k + 1] < 0 ? 1 : 0);
                }
            }
            return ans;
        }
    }
}
