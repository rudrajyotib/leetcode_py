from unittest import TestCase

from medium.dp.guess_number_higher_lower_2 import Solution


class TestSolution(TestCase):
    def test_get_money_amount(self):
        solution = Solution()
        self.assertEqual(16, solution.getMoneyAmount(n=10))
        self.assertEqual(34, solution.getMoneyAmount(n=16))
        self.assertEqual(0, solution.getMoneyAmount(n=1))
        self.assertEqual(1, solution.getMoneyAmount(n=2))
        self.assertEqual(2, solution.getMoneyAmount(n=3))
        self.assertEqual(4, solution.getMoneyAmount(n=4))
        self.assertEqual(8, solution.getMoneyAmount(n=6))
