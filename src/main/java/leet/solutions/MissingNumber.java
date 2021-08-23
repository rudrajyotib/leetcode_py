package leet.solutions;

/*
https://leetcode.com/problems/missing-number/
Leetcode#268
 */


import java.util.Arrays;

public class MissingNumber {

    public int solve(int[] nums) {
        Solution solution = new Solution();
        return solution.missingNumber(nums);
    }

    class Solution {
        public int missingNumber(int[] nums) {
            return ((nums.length) * ((nums.length) + 1) / 2) - Arrays.stream(nums).sum();
        }
    }
}
