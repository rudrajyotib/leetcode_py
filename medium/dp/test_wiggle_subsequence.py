from unittest import TestCase

from medium.dp.wiggle_subsequence import Solution


class TestSolution(TestCase):
    def test_wiggle_max_length(self):
        solution = Solution()
        self.assertEqual(3, solution.wiggleMaxLength(nums=[1, 4, 4, 2, 2, 1]))
        self.assertEqual(6, solution.wiggleMaxLength(nums=[1,7,4,9,2,5]))
        self.assertEqual(1, solution.wiggleMaxLength(nums=[1,1,1,1,1,1]))
        self.assertEqual(2, solution.wiggleMaxLength(nums=[1,2]))
