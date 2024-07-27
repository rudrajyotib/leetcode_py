/*
https://leetcode.com/problems/minimum-cost-to-convert-string-i
 */

package leet.solutions;

public class MinCostToConvertString1 {

    public long solve(String source, String target, char[] original, char[] changed, int[] cost){
        return new Solution().minimumCost(source, target, original, changed, cost);
    }

    static class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            long[][] adjMatrix = new long[26][26];
            for (int i=0;i<26;i++){
                for (int j = 0;j<26; j ++){
                    adjMatrix[i][j] = -1;
                }
            }
            for (int i=0;i<original.length;i++){
                adjMatrix[original[i]-'a'][changed[i]-'a'] = adjMatrix[original[i]-'a'][changed[i]-'a'] == -1 ? cost[i]
                        : Math.min(cost[i], adjMatrix[original[i]-'a'][changed[i]-'a']);
            }
            for (int i=0;i<26;i++){
                for (int j = 0;j<26;j++){
                    for (int k =0;k<26;k++){
                        if (j == k ){
                            continue;
                        }
                        if (adjMatrix[j][i] == -1 || adjMatrix[i][k] == -1){
                            continue;
                        }
                        long jk = adjMatrix[j][i] + adjMatrix[i][k];
                        if ( adjMatrix[j][k] == -1){
                            adjMatrix[j][k] = jk;
                        }else {
                            adjMatrix[j][k] = Math.min(adjMatrix[j][k], jk);
                        }
                    }
                }
            }
            long totalCost = 0;
            for(int i=0;i<source.length();i++){
                if (source.charAt(i) != target.charAt(i)){
                    long changeCost = adjMatrix[source.charAt(i)-'a'][target.charAt(i)-'a'];
                    if (changeCost == -1){
                        return -1;
                    }
                    totalCost += changeCost;
                }
            }

            return totalCost;
        }
    }

}
