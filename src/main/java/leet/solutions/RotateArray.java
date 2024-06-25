/*
https://leetcode.com/problems/rotate-array/
 */

package leet.solutions;

public class RotateArray {

    public void solve(int[] nums, int k){
        new Solution().rotate(nums, k);
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k%nums.length;
            revert(nums, 0, nums.length-1);
            revert(nums, 0, k-1);
            revert(nums, k, nums.length-1);
        }

        private void revert(int[] nums, int start, int end){
            if (start == end){
                return;
            }
            int leftPointer = start;
            int rightPointer = end;
            while (leftPointer<rightPointer){
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
                ++leftPointer;
                --rightPointer;
            }
        }
    }

}
