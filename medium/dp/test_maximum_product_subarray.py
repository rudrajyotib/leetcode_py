from unittest import TestCase

from medium.dp.maximum_product_subarray import Solution


class TestSolution(TestCase):
    def test_max_product(self):
        solution = Solution()
        self.assertEqual(6, solution.maxProduct(nums=[2, 3, -2, 4]))
        self.assertEqual(6, solution.maxProduct(nums=[2, 3, 0, -2, 4]))
        self.assertEqual(8, solution.maxProduct(nums=[2, 3, 0, -2, -4]))
        self.assertEqual(96, solution.maxProduct(nums=[2, -3, 1, -2, -4, 2, -1]))
        self.assertEqual(16, solution.maxProduct(nums=[2, -3, 1, -2, -4, 2, 1]))
        self.assertEqual(2, solution.maxProduct(nums=[2]))
        self.assertEqual(8, solution.maxProduct(nums=[-2, -4]))
