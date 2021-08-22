package leet.solutions;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Leetcode#153
 */


public class MinimumInSortedRotatedArray {

    public int solve(int[] min)
    {
        Solution solution = new Solution();
        return solution.findMin(min);
    }

    class Solution {
        public int findMin(int[] nums) {
            int length = nums.length;
            if (nums.length == 1)
            {
                return nums[0];
            }
            if (nums.length == 2)
            {
                return Math.min(nums[0], nums[1]);
            }
            if (nums[length-1] > nums[0])
            {
                return nums[0];
            }
            return findMinRecursive(nums, 0, nums.length-1);
        }

        private int findMinRecursive(int[] nums, int start, int end)
        {
            int mid = findMid(start, end);
            if (mid == 0)
            {
                return nums[mid];
            }
            if (nums[mid] < nums[mid-1])
            {
                return nums[mid];
            }
            if (nums[mid] >= nums[start])
            {
                return findMinRecursive(nums, mid, end);
            }else
            {
                return findMinRecursive(nums, start, mid);
            }
        }

        private int findMid(int start, int end)
        {
            if((start+end)%2==1)
            {
                return ((start+end)/2)+1;
            }
            return (start+end)/2;
        }

    }

}
