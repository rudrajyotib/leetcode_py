from unittest import TestCase

from medium.dp.house_robber import Solution


class TestSolution(TestCase):
    def test_rob(self):
        solution = Solution()
        self.assertEqual(26, solution.rob(nums=[2, 0, 0, 16, 1, 1, 8]))
        self.assertEqual(2, solution.rob(nums=[2]))
        self.assertEqual(12, solution.rob(nums=[2, 12]))
        self.assertEqual(15, solution.rob(nums=[2, 12, 13]))
        self.assertEqual(12, solution.rob(nums=[2, 12, 3]))
