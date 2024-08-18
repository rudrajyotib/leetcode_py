/*
https://www.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1
 */

package gfg;

import java.util.List;

public class MaxSumPathInTwoArrays {

    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int index1 = 0;
        int index2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        int resultSum = 0;
        while (index1 < arr1.size() && index2 < arr2.size()) {
            int el1 = arr1.get(index1);
            int el2 = arr2.get(index2);
            if (el1 > el2) {
                sum2 += arr2.get(index2);
                ++index2;
            } else if (el2 > el1) {
                sum1 += arr1.get(index1);
                ++index1;
            } else {
                resultSum += Math.max(sum1, sum2) + el1;
                sum1 = 0;
                sum2 = 0;
                ++index2;
                ++index1;
            }
        }
        while (index1 < arr1.size()) {
            sum1 += arr1.get(index1);
            ++index1;
        }
        while (index2 < arr2.size()) {
            sum2 += arr2.get(index2);
            ++index2;
        }
        return resultSum + Math.max(sum1, sum2);
    }

}
