package leet.solutions;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
Leetcode#81
 */

public class SearchInRotateSortedArray2 {

    public boolean solve(int[] nums, int target) {
        Solution solution = new Solution();
        return solution.search(nums, target);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean search(int[] nums, int target) {
            int pivotPoint = findPivotPoint(nums, 0, nums.length - 1, nums.length - 1);
            if (pivotPoint == -1) {
                return binarySearch(0, nums.length - 1, nums, target);
            } else {
                return binarySearch(0, pivotPoint, nums, target)
                        || binarySearch(pivotPoint + 1, nums.length - 1, nums, target);
            }
        }

        private int findPivotPoint(int[] nums, int start, int end, int limit) {
            if (start >= limit) {
                return -1;
            }
            if (start > end)
            {
                return -1;
            }
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (start == end)
            {
                if (nums[start] > nums[start+1])
                {
                    return start;
                }else
                {
                    return -1;
                }
            }
            if (nums[mid] == nums[start]) {
                if (nums[mid] == nums[end]) {
                    return Math.max(findPivotPoint(nums, start, mid - 1, limit), findPivotPoint(nums, mid + 1, end, limit));
                }else
                {
                    return findPivotPoint(nums, mid + 1, end, limit);
                }
            }
            else if (nums[mid] > nums[start]) {
                return findPivotPoint(nums, mid + 1, end, limit);
            } else {
                return findPivotPoint(nums, start, mid - 1, limit);
            }
        }

        private boolean binarySearch(int start, int end, int[] nums, int target) {
            if (start == end) {
                return nums[start] == target;
            }
            if (start > end) {
                return false;
            }
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target < nums[mid]) {
                return binarySearch(start, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, end, nums, target);
            }
        }
    }

}
