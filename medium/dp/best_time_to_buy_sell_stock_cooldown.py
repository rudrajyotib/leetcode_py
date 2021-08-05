from typing import List, Tuple

"""
https://www.youtube.com/watch?v=4wNXkhAky3s
"""


class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        if len(prices) == 1:
            return 0

        daily_stock_holding: List[Tuple] = [(0, -prices[0], 0)]
        for day in range(1, len(prices), 1):
            daily_stock_holding.append(
                (max(daily_stock_holding[day - 1][0], daily_stock_holding[day - 1][2]),
                 max(daily_stock_holding[day - 1][0] - prices[day], daily_stock_holding[day - 1][1]),
                 daily_stock_holding[day - 1][1] + prices[day])
            )

        return max(daily_stock_holding[-1])
