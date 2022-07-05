package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/add-one-to-number/
 */


import java.util.Stack;

public class AddOneToNumber {


    public int[] solve(int[] input) {
        return new Solution().plusOne(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int[] plusOne(int[] input) {

            int startOfRealMostSignificantBit = findMostSignificantNonZeroBit(input);
            if (startOfRealMostSignificantBit == -1) {
                return new int[]{1};
            }
            Stack<Integer> sum = new Stack<>();
            boolean carry = true;
            for (int i = input.length - 1; i >= startOfRealMostSignificantBit; i--) {
                if (!carry) {
                    sum.push(input[i]);
                } else {
                    if (input[i] == 9) {
                        sum.push(0);
                    } else {
                        sum.push(input[i] + 1);
                        carry = false;
                    }
                }
            }
            int resultSize = carry ? (input.length - startOfRealMostSignificantBit) + 1 : (input.length - startOfRealMostSignificantBit);
            int[] result = new int[resultSize];
            int resultCounter = 0;
            if (carry) {
                result[0] = 1;
                resultCounter = 1;
            }
            while (!sum.isEmpty()) {
                result[resultCounter] = sum.pop();
                ++resultCounter;
            }


            return result;
        }

        private int findMostSignificantNonZeroBit(int[] input) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != 0) {
                    return i;
                }
            }
            return -1;
        }


    }


}
