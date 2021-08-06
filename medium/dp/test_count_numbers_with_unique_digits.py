from unittest import TestCase

from medium.dp.count_numbers_with_unique_digits import Solution


class TestSolution(TestCase):
    def test_count_numbers_with_unique_digits(self):
        solution = Solution()
        self.assertEqual(91, solution.countNumbersWithUniqueDigits(n=2))
