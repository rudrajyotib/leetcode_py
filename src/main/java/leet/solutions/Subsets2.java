package leet.solutions;

/*
https://leetcode.com/problems/subsets-ii/
Leetcode#90
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.subsetsWithDup(nums);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private final List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            recursiveSubset(0, nums, new LinkedList<>());
            return result;
        }

        private void recursiveSubset(int startIndex, int[] nums, LinkedList<Integer> trail)
        {
            result.add(new ArrayList<>(trail));
            for (int i=startIndex;i<nums.length;i++)
            {
                if ( (i!=startIndex) && (nums[i-1] == nums[i]))
                {
                    continue;
                }
                trail.addLast(nums[i]);
                recursiveSubset(i+1, nums, trail);
                trail.removeLast();
            }
        }

    }

}
