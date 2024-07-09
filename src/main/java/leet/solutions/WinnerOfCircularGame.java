/*
https://leetcode.com/problems/find-the-winner-of-the-circular-game
Josephus problem
https://www.geeksforgeeks.org/josephus-problem/
 */

package leet.solutions;

public class WinnerOfCircularGame {

    public int solve(int n, int k){
        return new Solution().findTheWinner(n, k);
    }


    static class Solution {
        public int findTheWinner(int n, int k) {
            int winner=0;
            for (int i = 1; i <= n; i++) {
                winner = (winner + k) % i;
            }
            return winner + 1;
        }
    }

}
