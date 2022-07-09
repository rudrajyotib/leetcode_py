package interviewbit.coderlift.july2022;

public class MaximumPossibleScore {

    public static class Solution {
        public int solve(int[] A, int[] B) {
            int[] scoreA = new int[A.length];
            int[] scoreB = new int[A.length];

            scoreA[0] = Math.max(A[0], 1);
            scoreB[0] = Math.max(B[0], 1);

            for (int i=1;i<A.length;i++){
                scoreA[i] = Math.max(scoreA[i-1]+A[i], scoreB[i-1]+1);
                scoreB[i] = Math.max(scoreB[i-1]+B[i], scoreA[i-1]+1);
            }

            return Math.max(scoreA[A.length-1], scoreB[A.length-1]);

        }


    }

}
