package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/highest-product/
 */


import java.util.Arrays;

public class HighestProduct {

    public int solve(int[] elements){
        return new Solution().maxp3(elements);
    }

    public static class Solution {
        public int maxp3(int[] A) {

            int[] max3 = new int[3];
            int[] min2 = new int[2];

            Arrays.fill(max3, Integer.MIN_VALUE);
            Arrays.fill(min2, Integer.MAX_VALUE);

            for (int element : A) {
                adjustInMaxVal(max3, element);
                adjustInMinVal(min2, element);
            }

            return Math.max((max3[0] * max3[1] * max3[2]), min2[0] * min2[1] * max3[2]) ;
        }

        private void adjustInMaxVal(int[] maxArray, int element) {
            if (element > maxArray[2]) {
                maxArray[0] = maxArray[1];
                maxArray[1] = maxArray[2];
                maxArray[2] = element;
            } else if (element > maxArray[1]) {
                maxArray[0] = maxArray[1];
                maxArray[1] = element;
            } else if (element > maxArray[0]) {
                maxArray[0] = element;
            }
        }

        private void adjustInMinVal(int[] minArray, int element) {
            if (element < minArray[1]) {
                minArray[0] = minArray[1];
                minArray[1] = element;
            } else if (element < minArray[0]) {
                minArray[0] = element;
            }
        }

    }


}
