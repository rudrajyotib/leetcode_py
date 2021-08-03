from unittest import TestCase

from medium.dp.unique_paths import Solution


class TestSolution(TestCase):
    def test_unique_paths(self):

        solution = Solution()

        self.assertEqual(28, solution.uniquePaths(m=3, n=7))
        self.assertEqual(6, solution.uniquePaths(m=3, n=3))
        self.assertEqual(1, solution.uniquePaths(m=1, n=1))
        self.assertEqual(2, solution.uniquePaths(m=2, n=2))
        self.assertEqual(1, solution.uniquePaths(m=1, n=100))
        self.assertEqual(1, solution.uniquePaths(m=10000, n=1))
