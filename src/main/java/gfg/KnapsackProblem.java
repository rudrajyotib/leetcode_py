/*
https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */

package gfg;

public class KnapsackProblem {

    static int knapSack(int W, int[] wt, int[] val) {
        // your code here
        int weightLen = wt.length;
        int[][] weights = new int[weightLen+1][W+1];
        for (int i=1;i<=weightLen;i++){
            for (int j=0;j<=W;j++){
                if (j >= wt[i-1]){
                    weights[i][j] = Math.max(weights[i-1][j-wt[i-1]]+val[i-1], weights[i-1][j]);
                }else {
                    weights[i][j] = weights[i-1][j];
                }

            }
        }

        return weights[weightLen][W];
    }

}
