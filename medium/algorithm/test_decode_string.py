from unittest import TestCase

from medium.algorithm.decode_string import Solution


class TestSolution(TestCase):
    def test_decode_string(self):
        solution = Solution()
        self.assertEqual("abc", solution.decodeString("abc"))
        self.assertEqual("abcc", solution.decodeString("ab2[c]"))
        self.assertEqual("abcaacaa", solution.decodeString("ab2[c2[a]]"))
        self.assertEqual("abcaacaab", solution.decodeString("ab2[c2[a]]b"))
        self.assertEqual("xxabcaacaab", solution.decodeString("2[x]ab2[c2[a]]b"))
        self.assertEqual("xxabcaacaacaacaacaacaacaacaacaacaab", solution.decodeString("2[x]ab10[c2[a]]b"))
