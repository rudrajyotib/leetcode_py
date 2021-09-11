package leet.solutions;

/*
https://leetcode.com/problems/combination-sum-ii/
Leetcode#40
 */

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> solve(int[] candidates, int target)
    {
        Solution solution = new Solution();
        return solution.combinationSum2(candidates, target);
    }


    class Solution {

        private List<List<Integer>> result;
        private int[] candidates;


        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.candidates = candidates;
            this.result = new ArrayList<>();
            Arrays.sort(this.candidates);
            this.combination(target, new LinkedList<>(), 0);
            return new ArrayList<>(this.result);
        }

        public void combination(int target, LinkedList<Integer> trail, int startIndex)
        {
            for (int i=startIndex;i<candidates.length;i++)
            {
                if((i>0) && (i>startIndex) && (this.candidates[i] == this.candidates[i-1]) )
                {
                    continue;
                }
                final int element = candidates[i];
                if (target == element)
                {
                    LinkedList<Integer> clone = new LinkedList<>(trail);
                    clone.add(target);
                    result.add(clone);
                }else if (target > element)
                {
                    trail.addLast(candidates[i] );
                    combination(target-candidates[i], trail, i+1);
                    trail.removeLast();
                }else
                {
                    break;
                }
            }
        }
    }

}
