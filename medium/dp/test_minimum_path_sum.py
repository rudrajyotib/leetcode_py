from unittest import TestCase

from medium.dp.minimum_path_sum import Solution


class TestSolution(TestCase):
    def test_min_path_sum(self):
        solution = Solution()
        self.assertEqual(7, solution.minPathSum(grid=[[1, 3, 1], [1, 5, 1], [4, 2, 1]]))
        self.assertEqual(3, solution.minPathSum(grid=[[1, 2, 2, 1], [1, 0, 0, 3], [1, 3, 0, 1], [0, 2, 0, 1]]))
        self.assertEqual(1, solution.minPathSum(grid=[[1]]))
        self.assertEqual(5, solution.minPathSum(grid=[[1], [1], [1], [1], [1]]))
        self.assertEqual(4, solution.minPathSum(grid=[[1, 1, 1, 1]]))
