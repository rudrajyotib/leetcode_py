from functools import cmp_to_key
from unittest import TestCase

from medium.algorithm.largest_number import compare_from_left, Solution


class TestCompare(TestCase):
    def test_compare(self):
        self.assertEqual(1, compare_from_left("11", "111"))
        self.assertEqual(-1, compare_from_left("11", "101"))
        self.assertEqual(-1, compare_from_left("11", "1101"))
        self.assertEqual(-1, compare_from_left("11", "1100"))
        self.assertEqual(1, compare_from_left("1100", "11"))
        # self.assertEqual(1, compare_from_left("111311", "1113"))

        self.assertEqual(["11", "110", "1100"], sorted(["1100", "110", "11"], key=cmp_to_key(compare_from_left)))
        # self.assertEqual(["1100", "11"], sorted(["1100", "11"], key=cmp_to_key(compare_from_left)))
        self.assertEqual(['112', '1121', '11'], sorted(["1121", "112", "11"], key=cmp_to_key(compare_from_left)))
        self.assertEqual(['1', '110', '10'], sorted(["1", "10", "110"], key=cmp_to_key(compare_from_left)))
        self.assertEqual(['1113', '111311'], sorted(["111311", "1113"], key=cmp_to_key(compare_from_left)))


class TestSolution(TestCase):
    def test_largest_number(self):
        solution = Solution()
        self.assertEqual("9534330", solution.largestNumber(nums=[3, 30, 34, 5, 9]))
        self.assertEqual("111010", solution.largestNumber(nums=[1, 10, 110]))
        self.assertEqual("0", solution.largestNumber(nums=[0, 0]))
        self.assertEqual("100", solution.largestNumber(nums=[1, 0, 0]))
