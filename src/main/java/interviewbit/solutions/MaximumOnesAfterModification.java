package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/maximum-ones-after-modification/
 */

import java.util.ArrayList;
import java.util.List;

public class MaximumOnesAfterModification {

    public int solve(ArrayList<Integer> list, int maxModifications) {
        return new Solution().solve(list, maxModifications);
    }


    public static class Solution {
        public int solve(ArrayList<Integer> A, int B) {

            List<Integer> listOfOnesCovered = new ArrayList<>();

            int oneCount = 0;
            for (Integer integer : A) {
                if (integer == 0) {
                    listOfOnesCovered.add(oneCount > 0 ? oneCount + 1 : 1);
                    oneCount = 0;
                } else {
                    ++oneCount;
                }
            }

            int totalOnes = 0;
            int maxOnes = 0;
            int zeroCount = 0;

            for (Integer integer : A) {
                ++totalOnes;
                if (integer == 0) {

                    if (zeroCount >= B) {
                        totalOnes -= listOfOnesCovered.get(zeroCount - B);
                    }
                    ++zeroCount;
                }
                maxOnes = Math.max(totalOnes, maxOnes);
            }

            return maxOnes;
        }


    }




}
