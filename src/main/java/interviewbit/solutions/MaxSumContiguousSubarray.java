package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */

public class MaxSumContiguousSubarray {

    public int solve(final int[] numbers){
        return new Solution().maxSubArray(numbers);
    }

    static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int maxSubArray(final int[] A) {
            int maxSum = A[0];
            int prevSum = A[0];

            for (int i=1;i<A.length;i++){
                prevSum = Math.max(A[i]+prevSum, A[i]);
                maxSum = Math.max(maxSum, prevSum);
            }
            return maxSum;
        }
    }

}
