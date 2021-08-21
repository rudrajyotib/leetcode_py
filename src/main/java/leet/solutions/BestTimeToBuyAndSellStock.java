package leet.solutions;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Leetcode#121
 */

public class BestTimeToBuyAndSellStock {

    public int solve(int[] prices) {
        Solution solution = new Solution();
        return solution.maxProfit(prices);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                }
            }
            return maxProfit;
        }
    }
}
