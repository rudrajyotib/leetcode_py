from unittest import TestCase

from medium.dp.coin_change import Solution


class TestSolution(TestCase):
    def test_coin_change(self):
        solution = Solution()
        self.assertEqual(2, solution.coinChange(coins=[1,2], amount=4))
        self.assertEqual(-1, solution.coinChange(coins=[2, 4], amount=11))
        self.assertEqual(-1, solution.coinChange(coins=[2, 4], amount=11))
        self.assertEqual(3, solution.coinChange(coins=[1, 2, 5], amount=11))
        self.assertEqual(1000, solution.coinChange(coins=[1], amount=1000))
