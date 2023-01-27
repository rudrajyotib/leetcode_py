package gfg;

import java.util.LinkedList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/2b70d42632a4e207569c6d2d777383e4603d6fe1/1
 */

public class GcdArray {

    public int solve(int subArrays, int[] array) {
        return new Solution().solve(array.length, subArrays, array);
    }


    static class Solution {
        public int solve(int N, int K, int[] arr) {
            // code here
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i - 1];
            }

            List<Integer> factors = new LinkedList<>();
            for (int i = 1; i <= Math.sqrt(arr[N - 1]); i++) {
                if (arr[N - 1] % i == 0) {
                    factors.add(i);
                    factors.add(arr[N - 1] / i);
                }
            }

            factors.sort((o1, o2) -> Integer.compare(o2, o1));

            for (Integer factor : factors) {
                int divideCount = 0;
                for (int i : arr) {
                    if (i % factor == 0) {
                        ++divideCount;
                    }
                }
                if (divideCount >= K) {
                    return factor;
                }
            }
            return 1;

        }


    }


}
