/*
https://leetcode.com/problems/corporate-flight-bookings/description/
 */

package leet.solutions;

public class CorporateFlightBookings {

    public int[] solve(int[][] bookings, int n){
        return new Solution().corpFlightBookings(bookings, n);
    }


    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] result = new int[n];
            for (int[] booking : bookings) {
                if (booking[0] <= n) {
                    result[booking[0] - 1] += booking[2];
                    if (booking[1] - 1 < n - 1) {
                        result[booking[1]] -= booking[2];
                    }
                }
            }
            for (int i=1;i<n;i++){
                result[i] += result[i-1];
            }
            return result;
        }
    }


}
