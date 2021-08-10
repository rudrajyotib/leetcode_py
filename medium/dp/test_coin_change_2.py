from unittest import TestCase

from medium.dp.coin_change_2 import Solution


class TestSolution(TestCase):
    def test_change(self):
        solution = Solution()
        self.assertEqual(4, solution.change(amount=5, coins=[1, 2, 5]))
