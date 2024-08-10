/*
https://www.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1
 */
package gfg;

import java.util.Arrays;

public class MaximizeArrayValueAfterRearrangement {
    int maximize(int[] arr) {
        // Complete the function
        Arrays.sort(arr);
        int mod = 1000000007;
        long result = 0;
        for (int i=0;i<arr.length;i++){
            result = (result + ((long)arr[i] * i) % mod) % mod;
        }
        return (int) result;
    }


}
