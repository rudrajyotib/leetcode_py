package leet.solutions;

/*
https://leetcode.com/problems/majority-element/
https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
 */

public class MajorityElement {

    public int solve(int[] nums){
        return new Solution().majorityElement(nums);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int majorityElement(int[] nums) {
            int presumedMajorityElement = nums[0];
            int selectionCount = 1;
            for (int i=1; i<nums.length; i++){
                if (selectionCount == 0) {
                    presumedMajorityElement = nums[i];
                    selectionCount = 1;
                }else {
                    if(nums[i] == presumedMajorityElement){
                        ++selectionCount;
                    }else{
                        --selectionCount;
                    }
                }
            }
            return presumedMajorityElement;
        }
    }

}
