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

            double totalWaitTime = 0d;
            int realEndTimePrev = customers[0][0] + customers[0][1];
            totalWaitTime += customers[0][1];
            for (int i = 1; i < customers.length; i++) {
                if (customers[i][0] > realEndTimePrev) {
                    realEndTimePrev = customers[i][0] + customers[i][1];
                } else {
                    realEndTimePrev = realEndTimePrev + customers[i][1];
                }
                totalWaitTime += (realEndTimePrev - customers[i][0]);
            }


            return totalWaitTime / customers.length;
        }
    }
}
