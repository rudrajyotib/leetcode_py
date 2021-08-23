package leet.solutions;

/*
https://leetcode.com/problems/contains-duplicate/
Leetcode#217
 */


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.containsDuplicate(nums);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num))
                {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }

}
