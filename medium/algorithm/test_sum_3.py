from unittest import TestCase

from medium.algorithm.sum_3 import Solution


class TestSolution(TestCase):
    def test_three_sum(self):
        solution = Solution()
        self.assertEqual([], solution.threeSum(nums=[0, 1, 2, 3]))
        self.assertEqual([[0, 0, 0]], solution.threeSum(nums=[0, 0, 0]))
        self.assertEqual([[0, 0, 0]], solution.threeSum(nums=[0, 0, 0, 0, 0, 0]))
        self.assertEqual([[-1, 0, 1]], solution.threeSum(nums=[-1, 0, 1, 2, 3]))
        self.assertEqual([[-1, -1, 2], [-1, 0, 1]], solution.threeSum(nums=[-1, -1, -1, 0, 1, 2, 3]))
