from unittest import TestCase

from medium.dp.largest_divisible_subset import Solution


class TestSolution(TestCase):
    def test_largest_divisible_subset(self):
        solution = Solution()
        self.assertEqual([2, 4, 8], solution.largestDivisibleSubset(nums=[2, 3, 4, 9, 8]))
        self.assertEqual([1, 3], solution.largestDivisibleSubset(nums=[1, 3]))
        self.assertEqual([1, 3, 6], solution.largestDivisibleSubset(nums=[1, 3, 6, 9]))
        self.assertEqual([1, 3, 9, 27], solution.largestDivisibleSubset(nums=[1, 3, 27, 9]))
        self.assertEqual([1], solution.largestDivisibleSubset(nums=[1]))
        self.assertEqual([1, 2, 4, 8, 24, 72], solution.largestDivisibleSubset(nums=[1, 2, 3, 4, 6, 8, 12, 24, 72]))
