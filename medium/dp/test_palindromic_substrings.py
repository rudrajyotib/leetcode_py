from unittest import TestCase

from medium.dp.palindromic_substrings import Solution


class TestSolution(TestCase):
    def test_count_substrings(self):
        solution = Solution()
        self.assertEqual(3, solution.countSubstrings(s="abc"))
        self.assertEqual(6, solution.countSubstrings(s="aaa"))
        self.assertEqual(6, solution.countSubstrings(s="aaa"))
        self.assertEqual(6, solution.countSubstrings(s="abba"))
