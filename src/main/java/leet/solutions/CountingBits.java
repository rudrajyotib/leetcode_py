package leet.solutions;

/*
https://leetcode.com/problems/counting-bits/
Leetcode#338
 */


public class CountingBits {


    public int[] solve(int n) {
        Solution solution = new Solution();
        return solution.countBits(n);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[] countBits(int n) {

            if (n == 0) {
                return new int[]{0};
            }
            int[] result = new int[n + 1];

            result[0] = 0;
            int lastKnownPowerOf2 = 1;
            int nextPowerOf2 = 2;

            for (int i = 1; i < n + 1; i++) {
                if (i == nextPowerOf2) {
                    result[i] = 1;
                    lastKnownPowerOf2 = nextPowerOf2;
                    nextPowerOf2 *= 2;
                } else {
                    result[i] = result[i - lastKnownPowerOf2] + 1;
                }
            }
            return result;
        }
    }
}
