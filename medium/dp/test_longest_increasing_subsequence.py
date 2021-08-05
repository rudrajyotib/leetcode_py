from unittest import TestCase

from medium.dp.longest_increasing_subsequence import Solution


class TestSolution(TestCase):
    def test_length_of_lis(self):
        solution = Solution()
        self.assertEqual(7, solution.lengthOfLIS(nums=[100, 10, 15, 17, 40, 2, 17, 19, 20, 21, 22]))
        self.assertEqual(4, solution.lengthOfLIS(nums=[10, 9, 2, 5, 3, 7, 101, 18]))
        self.assertEqual(1, solution.lengthOfLIS(nums=[5, 4, 3, 2, 2, 2, 1, 0]))
        self.assertEqual(1, solution.lengthOfLIS(nums=[5]))
        self.assertEqual(1, solution.lengthOfLIS(nums=[5, 5, 5, 5, 5]))
