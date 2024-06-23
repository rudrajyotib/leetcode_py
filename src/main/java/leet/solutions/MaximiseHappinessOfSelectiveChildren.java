/*
https://leetcode.com/problems/maximize-happiness-of-selected-children/
 */

package leet.solutions;

import java.util.Arrays;

public class MaximiseHappinessOfSelectiveChildren {

    public long solve(int[] happiness, int k){
        return  new Solution().maximumHappinessSum(happiness, k);
    }

    static class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {

            long result = 0;
            Arrays.sort(happiness);
            int index = happiness.length  - 1;
            int turns = 0;
            while (index>=0 && turns < k ){
                int val = happiness[index];
                val = val - turns;
                if (val > 0){
                    result += val;
                }
                --index;
                ++turns;
            }

            return result;
        }
    }
}
