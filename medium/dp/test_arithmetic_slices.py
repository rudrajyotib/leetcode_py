from unittest import TestCase

from medium.dp.arithmetic_slices import Solution


class TestSolution(TestCase):
    def test_number_of_arithmetic_slices(self):
        solution = Solution()
        self.assertEqual(3, solution.numberOfArithmeticSlices(nums=[1, 2, 3, 4]))
        self.assertEqual(2, solution.numberOfArithmeticSlices(nums=[1, 2, 3, 8,9,10]))
        self.assertEqual(4, solution.numberOfArithmeticSlices(nums=[1, 2, 3, 6, 9, 12]))
        self.assertEqual(0, solution.numberOfArithmeticSlices(nums=[1, 2]))
