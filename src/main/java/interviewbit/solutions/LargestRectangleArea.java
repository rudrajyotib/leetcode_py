package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 */

import java.util.ArrayList;

public class LargestRectangleArea {

    public int solve(ArrayList<Integer> histogram) {
        return new Solution().largestRectangleArea(histogram);
    }


    public static class Solution {
        public int largestRectangleArea(ArrayList<Integer> histogram) {

            int[] left = new int[histogram.size()];
            int[] right = new int[histogram.size()];
            int maxArea = histogram.get(0);

            left[0] = 0;
            right[histogram.size() - 1] = histogram.size() - 1;
            for (int i = 1; i < histogram.size(); i++) {
                int leftLimit = i-1;
                left[i] = i;
                while (leftLimit >=0 && histogram.get(leftLimit)>=histogram.get(i)){
                    leftLimit = left[leftLimit];
                    left[i] = leftLimit;
                    --leftLimit;
                }
            }

            for (int i =  histogram.size()-2; i>=0 ; i--) {
                int rightLimit = i+1;
                right[i] = i;
                while (rightLimit <= histogram.size()-1 && histogram.get(rightLimit)>=histogram.get(i)){
                    rightLimit = right[rightLimit];
                    right[i] = rightLimit;
                    ++rightLimit;
                }
            }

            for (int i=0;i<=histogram.size()-1;i++){
                maxArea = Math.max(maxArea, histogram.get(i)* (right[i]-left[i]+1));
            }



            return maxArea;
        }
    }


}
