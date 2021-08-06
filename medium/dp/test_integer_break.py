from unittest import TestCase

from medium.dp.integer_break import Solution


class TestSolution(TestCase):
    def test_integer_break_recursive(self):
        solution = Solution()
        self.assertEqual(9, solution.integerBreak(n=6))
        self.assertEqual(12, solution.integerBreak(n=7))
        self.assertEqual(27, solution.integerBreak(n=9))
        self.assertEqual(1, solution.integerBreak(n=2))
        self.assertEqual(2, solution.integerBreak(n=3))
