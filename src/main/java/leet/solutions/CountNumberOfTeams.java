/*
https://leetcode.com/problems/count-number-of-teams
 */

package leet.solutions;

public class CountNumberOfTeams {

    public int solve(int[] ratings){
        return new Solution().numTeams(ratings);
    }

    static class Solution {
        public int numTeams(int[] rating) {
            int len = rating.length;
            int[] lowerThanMeLeft = new int[len];
            int[] lowerThanMeRight = new int[len];
            int[] higherThanMeLeft = new int[len];
            int[] higherThanMeRight = new int[len];
            for (int i=0;i<len;i++){
                for (int j=0;j<len;j++){
                    if (rating[j]<rating[i]){
                        if (j < i ){
                            ++lowerThanMeLeft[i];
                        }else if (j > i){
                            ++lowerThanMeRight[i];
                        }
                    }else if (rating[j] > rating[i]){
                        if (j < i ){
                            ++higherThanMeLeft[i];
                        }else if (j > i){
                            ++higherThanMeRight[i];
                        }
                    }
                }
            }
            int tot = 0;
            for (int i=0;i<len;i++){
                tot += (lowerThanMeLeft[i]*higherThanMeRight[i] + lowerThanMeRight[i]*higherThanMeLeft[i]);
            }
            return tot;
        }
    }
}
