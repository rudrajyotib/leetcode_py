package interviewbit.solutions;

public class LongestIncreasingSubsequence {

    public int solve(final int[] numbers){
        return new Solution().lis(numbers);
    }

    static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int lis(final int[] A) {

            int[] lisArray = new int[A.length];
            int maxLength = 1;
            lisArray[0] = 1;

            for (int i=1;i<A.length;i++){
                lisArray[i] = 1;
                for (int j = 0;j<i;j++){
                    if (A[j] < A[i]){
                        lisArray[i] = Math.max(lisArray[i], 1+lisArray[j]);
                        maxLength = Math.max(maxLength, lisArray[i]);
                    }
                }
            }
            return maxLength;
        }
    }

}
