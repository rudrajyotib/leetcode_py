from unittest import TestCase

from medium.dp.ugly_number_2 import Solution


class TestSolution(TestCase):
    def test_nth_ugly_number(self):
        solution = Solution()
        self.assertEqual(12, solution.nthUglyNumber(10))
        self.assertEqual(1, solution.nthUglyNumber(1))
