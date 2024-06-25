/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 */

package leet.solutions;

public class RemoveDuplicatesFromSortedArray2 {

    public int solve(int[] nums){
        return new Solution().removeDuplicates(nums);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int replacePointer = 0;
            int streak = 1;
            for (int i=1;i< nums.length;i++){
                if (nums[i] == nums[replacePointer]){
                    ++streak;
                    if (streak <= 2){
                        ++replacePointer;
                        nums[replacePointer] = nums[i];
                    }
                }else {
                    streak = 1;
                    ++replacePointer;
                    nums[replacePointer] = nums[i];
                }

            }
            return replacePointer+1;
        }
    }
}
