from unittest import TestCase

from medium.dp.unique_bst import Solution


class TestSolution(TestCase):
    def test_count_unique_bst_recursive(self):
        solution = Solution()
        self.assertEqual(132, solution.numTrees(n=6))
        self.assertEqual(429, solution.numTrees(n=7))
