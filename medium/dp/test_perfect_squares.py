from unittest import TestCase

from medium.dp.perfect_squares import Solution


class TestSolution(TestCase):
    def test_num_squares(self):
        solution = Solution()
        self.assertEqual(2, solution.numSquares(n=20))
        self.assertEqual(2, solution.numSquares(n=2))
        self.assertEqual(3, solution.numSquares(n=3))
        self.assertEqual(2, solution.numSquares(n=5))
        self.assertEqual(3, solution.numSquares(n=14))
        self.assertEqual(3, solution.numSquares(n=12))
        self.assertEqual(2, solution.numSquares(n=13))
        self.assertEqual(2, solution.numSquares(n=4850))
