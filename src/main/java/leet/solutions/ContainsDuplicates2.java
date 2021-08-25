package leet.solutions;

/*
https://leetcode.com/problems/contains-duplicate-ii/
Leetcode#219
 */

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates2 {

    public boolean solve(int[] nums, int k)
    {
        Solution solution = new Solution();
        return solution.containsNearbyDuplicate(nums, k);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        class Position
        {
            private int index;

            public Position(int index) {
                this.index = index;
            }

            public boolean updateIfNeeded(int newIndex, int window)
            {
                if ((newIndex - index) <= window)
                {
                    return true;
                }
                this.index = newIndex;
                return false;
            }
        }

        public boolean containsNearbyDuplicate(int[] nums, int k) {

            if (nums.length == 1)
            {
                return k == 0;
            }

            Map<Integer, Position> numberPositions = new HashMap<>();
            for (int i=0;i<nums.length;i++)
            {
                if (numberPositions.containsKey(nums[i]))
                {
                    if (numberPositions.get(nums[i]).updateIfNeeded(i, k))
                    {
                        return true;
                    }
                }else
                {
                    numberPositions.put(nums[i], new Position(i));
                }
            }


            return false;
        }
    }

}
