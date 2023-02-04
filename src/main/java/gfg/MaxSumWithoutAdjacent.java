package gfg;

/*
https://practice.geeksforgeeks.org/problems/7a33c749a79327b2889d420dd80342fff33aac6d/1
 */

public class MaxSumWithoutAdjacent {

    public int solve(int[] array){
        return new Solution().findMaxSum(array, array.length);
    }

    static class Solution {
        int findMaxSum(int[] array, int n) {
            if (array.length == 1){
                return array[0];
            }
            if (array.length<=2){
                return Math.max(array[0], array[1]);
            }
            if (array.length == 3){
                return Math.max(array[0]+array[2], array[1]);
            }

            array[n-3] = array[n-3]+array[n-1];
            int max = Math.max(array[n-3], Math.max(array[n-1], array[n-2]));
            for (int i=n-4;i>=0;i--){
                array[i] += Math.max(array[i+2], array[i+3]);
                max = Math.max(array[i], max);
            }

            // code here
            return max;
        }
    }

}
