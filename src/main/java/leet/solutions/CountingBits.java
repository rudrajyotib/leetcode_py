package leet.solutions;

/*
https://leetcode.com/problems/counting-bits/
Leetcode#338
 */


import java.util.HashSet;
import java.util.Set;

public class CountingBits {


    public int[] solve(int n) {
        Solution solution = new Solution();
        return solution.countBits(n);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[] countBits(int n) {

            double powerOf2 = 0;
            int power = -1;
            Set<Integer> powerOf2s = new HashSet<>();
            while (powerOf2 <= n) {
                powerOf2s.add((int) powerOf2);
                ++power;
                powerOf2 = Math.pow(2, power);
            }

            int[] result = new int[n + 1];

            result[0] = 0;
            int lastKnownPowerOf2 = 1;

            for (int i = 1; i < n + 1; i++) {
                if (powerOf2s.contains(i)) {
                    result[i] = 1;
                    lastKnownPowerOf2 = i;
                } else {
                    result[i] = result[i - lastKnownPowerOf2] + 1;
                }
            }
            return result;
        }
    }
}
