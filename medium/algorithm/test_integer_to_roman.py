from unittest import TestCase

from medium.algorithm.integer_to_roman import Solution


class TestSolution(TestCase):
    def test_int_to_roman(self):
        solution = Solution()
        self.assertEqual("II", solution.intToRoman(2))
        self.assertEqual("XII", solution.intToRoman(12))
        self.assertEqual("XXII", solution.intToRoman(22))
        self.assertEqual("XLII", solution.intToRoman(42))
        self.assertEqual("XXV", solution.intToRoman(25))
        self.assertEqual("XXVI", solution.intToRoman(26))
        self.assertEqual("M", solution.intToRoman(1000))
        self.assertEqual("MI", solution.intToRoman(1001))
        self.assertEqual("MMMCMXCIX", solution.intToRoman(3999))
