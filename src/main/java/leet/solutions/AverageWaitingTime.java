/*
https://leetcode.com/problems/average-waiting-time
 */

package leet.solutions;

public class AverageWaitingTime {

    public double solve(int[][] customers) {
        return new Solution().averageWaitingTime(customers);
    }

    static class Solution {
        public double averageWaitingTime(int[][] customers) {

            double totalWeightTime = 0d;
            int realEndTimePrev = customers[0][0] + customers[0][1];
            totalWeightTime += customers[0][1];
            for (int i = 1; i < customers.length; i++) {
                int startTime = customers[i][0];
                if (startTime > realEndTimePrev) {
                    realEndTimePrev = startTime + customers[i][1];
                } else {
                    realEndTimePrev = realEndTimePrev + customers[i][1];
                }
                totalWeightTime += (realEndTimePrev - startTime);
            }


            return totalWeightTime / customers.length;
        }
    }
}
