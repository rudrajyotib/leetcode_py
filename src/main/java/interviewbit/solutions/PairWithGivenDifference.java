package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/pair-with-given-difference/
 */

import java.util.ArrayList;
import java.util.Objects;

public class PairWithGivenDifference {

    public int solve(ArrayList<Integer> list, int difference) {
        return new Solution().solve(list, difference);
    }

    public static class Solution {
        public int solve(ArrayList<Integer> A, int B) {

            A.sort(Integer::compare);
            int nearPointer = 0;
            int farPointer = 0;
            int absDifference = Math.abs(B);

            if (B == 0) {
                for (int i = 0; i <= A.size() - 2; i++) {
                    if (Objects.equals(A.get(i), A.get(i + 1))) {
                        return 1;
                    }
                }
                return 0;
            }

            while (farPointer < A.size() && nearPointer < A.size()) {
                int difference = A.get(farPointer) - A.get(nearPointer);
                if (difference == absDifference) {
                    return 1;
                }
                if (difference < absDifference) {
                    ++farPointer;
                } else {
                    ++nearPointer;
                }
            }


            return 0;
        }
    }


}
