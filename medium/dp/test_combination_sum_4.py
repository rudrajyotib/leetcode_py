from unittest import TestCase

from medium.dp.combination_sum_4 import Solution


class TestSolution(TestCase):
    def test_combination_sum4(self):
        solution = Solution()
        self.assertEqual(7, solution.combinationSum4(nums=[1, 2, 3], target=4))
        self.assertEqual(31, solution.combinationSum4(nums=[1, 2, 4], target=7))
        self.assertEqual(1, solution.combinationSum4(nums=[1], target=7))
