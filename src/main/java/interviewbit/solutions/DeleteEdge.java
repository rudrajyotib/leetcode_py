package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/delete-edge/
 */

public class DeleteEdge {

    public int solve(int[] weights, int[][] adjacencyMatrix) {
        return new Solution().deleteEdge(weights, adjacencyMatrix);
    }

    public static class Solution {
        public int deleteEdge(int[] A, int[][] B) {

            int[][] dp = new int[A.length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    dp[i][j] = -1;
                }
            }
            boolean[][] adjacencyMatrix = new boolean[A.length][A.length];

            for (int[] edge : B) {
                adjacencyMatrix[edge[0] - 1][edge[1] - 1] = true;
                adjacencyMatrix[edge[1] - 1][edge[0] - 1] = true;
            }
            int totalSumOfWeights = 0;
            for (int k : A) {
                totalSumOfWeights += k;
            }

            calculateSubTreeSum(adjacencyMatrix, 0, dp, A);

            int minDifference = Integer.MAX_VALUE;
            int minDifferenceAt = 0;

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (dp[i][j] > -1) {
                        int otherPart = totalSumOfWeights - dp[i][j];
                        if (Math.abs(dp[i][j] - otherPart) < minDifference) {
                            minDifference = Math.abs(dp[i][j] - otherPart);
                            minDifferenceAt = dp[i][j];
                            dp[i][j] = -1;
                            dp[j][i] = -1;
                        }
                    }
                }
            }

            return (int) (((long) ((totalSumOfWeights - minDifferenceAt)) * (minDifferenceAt)) % 1000000007);
        }

        private int calculateSubTreeSum(boolean[][] adjacencyMatrix, int parent, int[][] dp, int[] weights) {
            int sum = 0;
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[parent][i]) {
                    adjacencyMatrix[parent][i] = false;
                    adjacencyMatrix[i][parent] = false;
                    int subtreeSum = calculateSubTreeSum(adjacencyMatrix, i, dp, weights);
                    dp[parent][i] = subtreeSum;
                    dp[i][parent] = subtreeSum;
                    sum += subtreeSum;
                }
            }
            return sum + weights[parent];
        }


    }

}
