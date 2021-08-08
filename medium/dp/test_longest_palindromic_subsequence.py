from unittest import TestCase

from medium.dp.longest_palindromic_subsequence import Solution


class TestSolution(TestCase):
    def test_longest_palindrome_subseq(self):
        solution = Solution()
        self.assertEqual(6, solution.longestPalindromeSubseq(s="abccba"))
        self.assertEqual(7, solution.longestPalindromeSubseq(s="abcccba"))
        self.assertEqual(1, solution.longestPalindromeSubseq(s="abcdef"))
        self.assertEqual(7, solution.longestPalindromeSubseq(s="aaaaaaa"))
        self.assertEqual(7, solution.longestPalindromeSubseq(s="abcdefcba"))
        self.assertEqual(12, solution.longestPalindromeSubseq(s="abcdefcbaxxabcfe"))
        self.assertEqual(4, solution.longestPalindromeSubseq(s="xaaaa"))
        self.assertEqual(14, solution.longestPalindromeSubseq(s="abcdcbaxxxxxxxxxxab"))
