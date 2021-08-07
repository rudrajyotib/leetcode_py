from unittest import TestCase

from medium.dp.integer_replacement import Solution


class TestSolution(TestCase):
    def test_integer_replacement(self):
        solution = Solution()
        self.assertEqual(0, solution.integerReplacement(n=1))
        self.assertEqual(3, solution.integerReplacement(n=8))
        self.assertEqual(4, solution.integerReplacement(n=7))
        self.assertEqual(3, solution.integerReplacement(n=6))
        self.assertEqual(10, solution.integerReplacement(n=514))
