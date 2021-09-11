package leet.solutions;

/*
Leetcode#39
https://leetcode.com/problems/combination-sum/
 */

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> solve(int[] candidates, int target)
    {
        Solution solution = new Solution();
        return solution.combinationSum(candidates, target);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private int[] candidates;
        private List<List<Integer>> result;


        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.result = new LinkedList<>();
            Arrays.sort(this.candidates);
            this.combination(target, new LinkedList<>(), 0);
            return result;
        }

        private void combination(int target, LinkedList<Integer> trail, int startIndex)
        {

            for (int i=startIndex;i<candidates.length;i++)
            {
                final int element = candidates[i];
                if (target == element)
                {
                    LinkedList<Integer> clone = new LinkedList<>(trail);
                    clone.add(target);
                    result.add(clone);
                }else if (target > element)
                {
                    trail.addLast(candidates[i] );
                    combination(target-candidates[i], trail, i);
                    trail.removeLast();
                }else
                {
                    break;
                }
            }
        }
    }
}
