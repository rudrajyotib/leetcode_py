package leet.solutions;

/*
https://leetcode.com/problems/number-of-1-bits/
Leetcode#191
 */

public class NumberOf1Bits {

    public int solve(int n)
    {
        Solution solution = new Solution();
        return solution.hammingWeight(n);
    }

    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            int rightBit1 = 0;
            while (n > 0)
            {
                rightBit1 += (n & 1);
                n = n >> 1;
            }
            return rightBit1;

        }
    }
}
