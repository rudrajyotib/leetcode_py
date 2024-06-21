/*
https://leetcode.com/problems/most-profit-assigning-work/description
 */


package leet.solutions;

public class MostProfitAssigningWork {

    public int solve(int[] difficulty, int[] profit, int[] worker) {
        return new Solution().maxProfitAssignment(difficulty, profit, worker);
    }


    static class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

            int maxDifficulty = 0;
            for (int k : difficulty) {
                if (k > maxDifficulty) {
                    maxDifficulty = k;
                }
            }
            int[] maxDifficultyProfiltRange = new int[maxDifficulty+1];
            for (int i=0;i<difficulty.length;i++){
                maxDifficultyProfiltRange[difficulty[i]] = Math.max(maxDifficultyProfiltRange[difficulty[i]], profit[i]);
            }
            for (int i=1;i<maxDifficultyProfiltRange.length;i++){
                maxDifficultyProfiltRange[i] = Math.max(maxDifficultyProfiltRange[i], maxDifficultyProfiltRange[i-1]);
            }
            int totalProfit = 0;
            for (int j : worker) {
                if (j > maxDifficulty) {
                    totalProfit += maxDifficultyProfiltRange[maxDifficulty];
                }else {
                    totalProfit += maxDifficultyProfiltRange[j];
                }
            }
            return totalProfit;
        }



    }

}
