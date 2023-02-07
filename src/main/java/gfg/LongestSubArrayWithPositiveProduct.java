package gfg;

/*
https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1
 */

public class LongestSubArrayWithPositiveProduct {

    public int solve(int[] array) {
        return new Solution().maxLength(array, array.length);
    }


    static class Solution {
        /* Function to return the length of the
           longest subarray with ppositive product */
        int maxLength(int[] arr, int n) {
            //code here
            int longestSubArray = 0;
            boolean negativeTrail = false;
            int negativePrefix = 0;
            int positivePrefix=0;

            for (int i = 0; i < n; i++) {
              if (arr[i] == 0){
                  negativeTrail = false;
                  negativePrefix = 0;
                  positivePrefix = 0;
                  continue;
              }
              if (arr[i]>0){
                  ++positivePrefix;
                  longestSubArray = Math.max(positivePrefix, longestSubArray);
              }else{
                  if (negativeTrail){
                      negativeTrail = false;
                      positivePrefix = negativePrefix+positivePrefix+2;
                      longestSubArray = Math.max(positivePrefix, longestSubArray);
                  }else{
                      negativeTrail = true;
                      negativePrefix = positivePrefix;
                      positivePrefix = 0;
                  }
              }
            }

            negativeTrail = false;
            negativePrefix = 0;
            positivePrefix = 0;


            for (int i = n-1; i >= 0; i--) {
                if (arr[i] == 0){
                    negativeTrail = false;
                    negativePrefix = 0;
                    positivePrefix = 0;
                    continue;
                }
                if (arr[i]>0){
                    ++positivePrefix;
                    longestSubArray = Math.max(positivePrefix, longestSubArray);
                }else{
                    if (negativeTrail){
                        negativeTrail = false;
                        positivePrefix = negativePrefix+positivePrefix+2;
                        longestSubArray = Math.max(positivePrefix, longestSubArray);
                    }else{
                        negativeTrail = true;
                        negativePrefix = positivePrefix;
                        positivePrefix = 0;
                    }
                }
            }
            return longestSubArray;
        }

    }

}
