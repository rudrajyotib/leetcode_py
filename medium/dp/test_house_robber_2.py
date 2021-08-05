from unittest import TestCase

from medium.dp.house_robber_2 import Solution


class TestSolution(TestCase):
    def test_rob(self):
        solution = Solution()
        self.assertEqual(16, solution.rob(nums=[2, 4, 6, 8, 10]))
        self.assertEqual(3, solution.rob(nums=[2, 3, 2]))
        self.assertEqual(4, solution.rob(nums=[1, 2, 3, 1]))
        self.assertEqual(4, solution.rob(nums=[4]))
        self.assertEqual(16, solution.rob(nums=[1, 2, 3, 4, 5, 1, 2, 3, 4, 5]))
