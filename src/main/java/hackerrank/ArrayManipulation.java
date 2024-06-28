/*
https://www.hackerrank.com/challenges/crush/
 */

package hackerrank;

import java.util.List;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long[] prefixSumArray = new long[n+2];
        for (List<Integer> query : queries) {
            prefixSumArray[query.get(0)]+=query.get(2);
            prefixSumArray[query.get(1)+1] -= query.get(2);
        }
        long max = Long.MIN_VALUE;
        for (int i=1;i<=n;i++){
            prefixSumArray[i]+=prefixSumArray[i-1];
            max = Math.max(prefixSumArray[i], max);
        }
        return max;
    }

}
