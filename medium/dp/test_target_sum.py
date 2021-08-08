from unittest import TestCase

from medium.dp.target_sum import Solution


class TestSolution(TestCase):
    def test_find_target_sum_ways(self):
        solution = Solution()
        self.assertEqual(1, solution.findTargetSumWays(nums=[1, 2, 3], target=4))
        self.assertEqual(0, solution.findTargetSumWays(nums=[2], target=4))
        self.assertEqual(1, solution.findTargetSumWays(nums=[2], target=2))
        self.assertEqual(1, solution.findTargetSumWays(nums=[2], target=-2))
        self.assertEqual(2, solution.findTargetSumWays(nums=[1, 2, 3], target=0))
        self.assertEqual(1, solution.findTargetSumWays(nums=[1, 2, 3], target=-6))
        self.assertEqual(5, solution.findTargetSumWays(nums=[1, 1, 1, 1, 1], target=3))
        self.assertEqual(256, solution.findTargetSumWays(nums=[0, 0, 0, 0, 0, 0, 0, 0, 1], target=1))
