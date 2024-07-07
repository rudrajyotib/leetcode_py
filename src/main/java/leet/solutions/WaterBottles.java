/*
https://leetcode.com/problems/water-bottles/
 */

package leet.solutions;

public class WaterBottles {

    public int solve(int x, int y){
        return new Solution().numWaterBottles(x, y);
    }

    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {

            int fullBottles = numBottles;
            int emptyBottles = 0;
            int answer = 0;

            while (!(fullBottles == 0 && emptyBottles < numExchange)){
                answer += fullBottles;
                emptyBottles += fullBottles;
                fullBottles = (emptyBottles / numExchange);
                emptyBottles = (emptyBottles % numExchange);
            }

            return answer;

        }
    }

}
