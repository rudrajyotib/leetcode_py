/*
https://www.geeksforgeeks.org/problems/number-of-pairs-1587115620/1
 */

package gfg;

import java.util.Arrays;

public class NumberOfPairs {

    public long countPairs(int[] x, int[] y) {
        Arrays.sort(y);
        int yLen = y.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i : y) {
            if (i == 0) {
                ++count0;
            }
            if (i == 1) {
                ++count1;
            }
            if (i == 2) {
                ++count2;
            }
            if (i == 3) {
                ++count3;
            }
            if (i == 4) {
                ++count4;
            }
        }
        int count01 = count0 + count1;
        // code here
        long result = 0L;
        for (int i : x) {
            if (i == 0) {
                continue;
            }
            if (i == 1) {
                result += count0;
                continue;
            }
            if (i == 2) {
                result += (count0 + count1 + (yLen - count1 - count0 - count2 - count3 - count4));
                continue;
            }
            if (i == 3) {
                result += (count0 + count1 + count2 + (yLen - count1 - count0 - count2 - count3));
                continue;
            }
            int insert = Arrays.binarySearch(y, i);
//            int idx = Arrays.binarySearch(Y, x);
            int ans;
            if (insert < 0) {
                insert = Math.abs(insert + 1);
                ans = y.length - insert;
            } else {
                while (insert < yLen && y[insert] == i) {
                    insert++;
                }
                ans = yLen - insert;
            }
            ans += count01;
            result += ans;

        }
        return result;
    }


}
