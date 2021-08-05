from unittest import TestCase

from medium.dp.best_time_to_buy_sell_stock_cooldown import Solution


class TestSolution(TestCase):
    def test_max_profit(self):
        solution = Solution()
        self.assertEqual(3, solution.maxProfit(prices=[1,2,3,0,2]))
        self.assertEqual(8, solution.maxProfit(prices=[8,10,12,14,16]))
        self.assertEqual(0, solution.maxProfit(prices=[8,8,8,8]))
        self.assertEqual(0, solution.maxProfit(prices=[8]))
        self.assertEqual(0, solution.maxProfit(prices=[10, 8]))
