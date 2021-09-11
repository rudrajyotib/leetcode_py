package leet.solutions;

/*
https://leetcode.com/problems/subsets/
Leetcode#78
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {


    public List<List<Integer>> solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.subsets(nums);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private final List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            recursiveSubset(0, nums, new LinkedList<>());
            return result;
        }

        private void recursiveSubset(int startIndex, int[] nums, LinkedList<Integer> trail)
        {
            result.add(new ArrayList<>(trail));
            for (int i=startIndex;i<nums.length;i++)
            {
                trail.addLast(nums[i]);
                recursiveSubset(i+1, nums, trail);
                trail.removeLast();
            }
        }
    }

}
