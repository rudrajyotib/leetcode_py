package leet.solutions;

/*
https://leetcode.com/problems/combinations/
Leetcode#77
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> solve(int n, int k)
    {
        Solution solution = new Solution();
        return solution.combine(n, k);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        List<List<Integer>> result = new LinkedList<>();
        int combinationLength;
        int maxNumber;

        public List<List<Integer>> combine(int n, int k) {
            this.combinationLength = k;
            this.maxNumber = n;
            if (n == k)
            {
                List<Integer> singleList = new ArrayList<>(n);
                for (int i=1;i<=n;i++)
                {
                    singleList.add(i);
                }
                result.add(singleList);
            }else {
                recursiveCombine(0, new LinkedList<>());
            }
            return result;
        }

        private void recursiveCombine(int start, LinkedList<Integer> trail)
        {
            int trailLength = trail.size();
            if (trailLength == combinationLength)
            {
                result.add(new ArrayList<>(trail));
                return;
            }
            int maxLimitOfCurrentIteration = maxNumber-(combinationLength-trailLength)+1;
            for (int i=start+1; i<=maxLimitOfCurrentIteration; i++)
            {
                trail.addLast(i);
                recursiveCombine(i, trail);
                trail.removeLast();
            }

        }

    }

}
