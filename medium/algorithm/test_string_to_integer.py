from unittest import TestCase

from medium.algorithm.string_to_integer import Solution


class TestSolution(TestCase):
    def test_my_atoi(self):
        solution = Solution()
        self.assertEqual(12, solution.myAtoi(s="12"))
        self.assertEqual(12, solution.myAtoi(s="12.12.12"))
        self.assertEqual(12, solution.myAtoi(s="12                  12"))
        self.assertEqual(12, solution.myAtoi(s="12a12"))
        self.assertEqual(12, solution.myAtoi(s="12a.12"))
        self.assertEqual(12, solution.myAtoi(s="12-12"))
        self.assertEqual(12, solution.myAtoi(s="0000000000000000000000000000000000000000000000012"))
        self.assertEqual(-12, solution.myAtoi(s="-12"))
        self.assertEqual(0, solution.myAtoi(s="useless stuffs -12"))
        self.assertEqual(0, solution.myAtoi(s=" No number"))
        self.assertEqual(9, solution.myAtoi(s="009 with some other useless stuffs"))
        self.assertEqual(9, solution.myAtoi(s="   009 with some other useless stuffs       "))
        self.assertEqual(-9, solution.myAtoi(s="   -009 with some other useless stuffs       "))
        self.assertEqual(0, solution.myAtoi(s="   -       "))
        self.assertEqual(0, solution.myAtoi(s="   +       "))
        self.assertEqual(0, solution.myAtoi(s="          "))
        self.assertEqual(-2147483648, solution.myAtoi(s="       -91283472332    "))
        self.assertEqual(-2147483648, solution.myAtoi(s="       -2147483648    "))
        self.assertEqual(-2147483648, solution.myAtoi(s="       -2147483649    "))
        self.assertEqual(2147483647, solution.myAtoi(s="       0000000000000000000000000000091283472332    "))
        self.assertEqual(3, solution.myAtoi(s="       3.39090    "))
